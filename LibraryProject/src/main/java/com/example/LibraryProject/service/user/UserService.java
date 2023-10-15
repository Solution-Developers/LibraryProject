package com.example.LibraryProject.service.user;

import com.example.LibraryProject.entity.enums.RoleType;
import com.example.LibraryProject.entity.user.User;
import com.example.LibraryProject.exception.BadRequestException;
import com.example.LibraryProject.exception.ResourceNotFoundException;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.payload.mapper.UserMapper;
import com.example.LibraryProject.payload.message.ErrorMessages;
import com.example.LibraryProject.payload.message.SuccessMessages;
import com.example.LibraryProject.payload.user.UserRequest;
import com.example.LibraryProject.payload.user.UserRequestForSignin;
import com.example.LibraryProject.payload.user.UserResponse;
import com.example.LibraryProject.payload.user.UserResponseWithToken;
import com.example.LibraryProject.repository.user.UserRepository;
import com.example.LibraryProject.security.jwt.JwtUtils;
import com.example.LibraryProject.security.service.UserDetailsImpl;
import com.example.LibraryProject.service.helper.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final PageableHelper pageableHelper;

    //It will return authenticated user object
    public ResponseMessage<UserResponse> createAuthenticatedUser(UserRequest userRequest,HttpServletRequest httpServletRequest) {
       String email=(String) httpServletRequest.getAttribute("email");
       User user=userRepository.findByEmail(email);
       user.setFirstName(userRequest.getFirstName());
       user.setLastName(userRequest.getLastName());
       user.setScore(userRequest.getScore());
       user.setAddress(userRequest.getAddress());
       user.setPhone(userRequest.getPhone());
       user.setPassword(userRequest.getPassword());
       user.setEmail(userRequest.getEmail());
       User savedUser = userRepository.save(user);

       return ResponseMessage.<UserResponse>builder()
               .object(userMapper.mapUserToUserResponse(savedUser))
               .httpStatus(HttpStatus.OK)
               .message(SuccessMessages.USER_UPDATE_MESSAGE)
               .build();
    }


    //It will authenticate the user/ signin
    public ResponseMessage<Object> signin(UserRequestForSignin userRequestForSignin) {
        String email=userRequestForSignin.getEmail();
        String password= userRequestForSignin.getPassword();

        if (!(email.equals(userRepository.findByEmail(email).getEmail()) &&
                password.equals(userRepository.findByEmail(email).getPassword()))){
            throw  new ResourceNotFoundException("Email or password is incorrect");
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token="Bearer "+ jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        Set<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
        Optional<String> role = roles.stream().findFirst();

        UserResponseWithToken.UserResponseWithTokenBuilder userResponse= UserResponseWithToken.builder();
        userResponse.firstName(userDetails.getFirstName());
        userResponse.lastName(userDetails.getLastName());
        userResponse.email(userDetails.getEmail());
        userResponse.token(token.substring(7));


        return ResponseMessage.builder()
                .message(token)
                .httpStatus(HttpStatus.OK)
                .object(userResponse)
                .build();

    }
    //It will return authenticated user loans
    public Page<UserResponse> getUserLoansWithPage(int page, int size, String sort, String type, HttpServletRequest httpServletRequest) {

        Pageable pageable= pageableHelper.getPageableWithProperties(page, size, sort, type);
        String email= (String) httpServletRequest.getAttribute("email");

        return userRepository.findByLoanListByPage(email,pageable);
    }



    //It will return a user
    public ResponseMessage<UserResponse> getUserById(Long userId){

        User user = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessages.NOT_FOUND_USER, userId)));

        UserResponse userResponse = userMapper.mapUserToUserResponse(user);

        return ResponseMessage.<UserResponse>builder()
                .message(SuccessMessages.USER_FOUND)
                .httpStatus(HttpStatus.OK)
                .object(userResponse)
                .build();

    }



    //It will delete the user
    public UserResponse deleteUserById(Long id, HttpServletRequest request){

        //user helper
        User user = userRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessages.NOT_FOUND_USER, id)));


        String email = (String) request.getAttribute("email");
        User user2 = userRepository.findByEmailEquals(email);

        if(Boolean.TRUE.equals(user.getBuiltIn())){
            throw new BadRequestException(ErrorMessages.NOT_PERMITTED);
        }else if(user2.getRoles().contains(RoleType.EMPLOYEE)){ // düşün

        }

    }

}
