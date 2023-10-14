package com.example.LibraryProject.service.user;

import com.example.LibraryProject.entity.user.User;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.payload.mapper.UserMapper;
import com.example.LibraryProject.payload.message.SuccessMessages;
import com.example.LibraryProject.payload.user.UserRequest;
import com.example.LibraryProject.payload.user.UserResponse;
import com.example.LibraryProject.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

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



}
