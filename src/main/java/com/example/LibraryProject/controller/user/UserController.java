package com.example.LibraryProject.controller.user;

import com.example.LibraryProject.entity.business.Publisher;
import com.example.LibraryProject.entity.user.User;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.payload.user.UserRequest;
import com.example.LibraryProject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.LibraryProject.payload.user.UserResponse;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    //It will return authenticated user objec
    @PostMapping("/user")
    @PreAuthorize("hasAnyAuthority('ADMIN','MEMBER','EMPLOYEE')")
    public ResponseMessage<UserResponse> createAuthenticatedUser(@RequestBody @Valid UserRequest userRequest,
                                                                 HttpServletRequest httpServletRequest){

        return userService.createAuthenticatedUser(userRequest,httpServletRequest);

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
