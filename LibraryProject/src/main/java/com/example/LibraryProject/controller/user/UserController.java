package com.example.LibraryProject.controller.user;

import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.payload.user.UserRequest;
import com.example.LibraryProject.payload.user.UserRequestForSignin;
import com.example.LibraryProject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.LibraryProject.payload.user.UserResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //It will authenticate the user/ signin
    @PostMapping("/signin")
    @PreAuthorize("hasAnyAuthority(' ANONYMOUS')")
    public ResponseMessage<Object> signin(@RequestBody @Valid UserRequestForSignin userRequestForSignin){
         return userService.signin(userRequestForSignin);
    }




    //It will return authenticated user objec
    @PostMapping("/user")
    @PreAuthorize("hasAnyAuthority('ADMIN','MEMBER','EMPLOYEE')")
    public ResponseMessage<UserResponse> createAuthenticatedUser(@RequestBody @Valid UserRequest userRequest,
                                                                 HttpServletRequest httpServletRequest){

        return userService.createAuthenticatedUser(userRequest,httpServletRequest);

    }

    //It will return authenticated user loans
    @PostMapping("/user/loans")
    @PreAuthorize("hasAnyAuthority('ADMIN','MEMBER','EMPLOYEE')")
    public Page<UserResponse> getUserLoansWithPage(@RequestParam(value = "page") int page,
                                                   @RequestParam(value = "size") int size,
                                                   @RequestParam(value = "sort") String sort,
                                                   @RequestParam(value = "type") String type,
                                                   @RequestBody HttpServletRequest httpServletRequest){
        return userService.getUserLoansWithPage(page,size,sort,type,httpServletRequest);
    }




    //It will return a user
    //@GetMapping



    //It will create a user
    //@PostMapping



    //It will update the user
    //@PutMapping


    //It will delete the user
    //@DeleteMapping


}
