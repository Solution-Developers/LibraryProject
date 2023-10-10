package com.example.LibraryProject.controller.user;

import com.example.LibraryProject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryProject.payload.user.UserResponse;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;



    public ResponseEntity<UserResponse> authenticatedUser(HttpServletRequest httpServletRequest){

        return null;
    }


}
