package com.example.LibraryProject.payload.mapper;

import com.example.LibraryProject.entity.user.User;
import com.example.LibraryProject.payload.user.UserRequest;
import com.example.LibraryProject.payload.user.UserRequestCreate;
import com.example.LibraryProject.payload.user.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    //request--> pojo
    public User mapUserRequestToUser(UserRequest userRequest){
        return User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .score(userRequest.getScore())
                .address(userRequest.getAddress())
                .phone(userRequest.getPhone())
                .email(userRequest.getEmail())
                .email(userRequest.getPassword())
                .build();
    }

    //pojo--> response
    public UserResponse mapUserToUserResponse(User user){
        return UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .score(user.getScore())
                .address(user.getAddress())
                .phone(user.getPhone())
                .birthDate(user.getBirthDate())
                .email(user.getEmail())
                .loanList(user.getLoanList())
                .build();
    }

    public  User MapUserRequestCreateToUser(UserRequestCreate userRequestCreate){
        return User.builder()
                .firstName(userRequestCreate.getFirstName())
                .lastName(userRequestCreate.getLastName())
                .address(userRequestCreate.getAddress())
                .phone(userRequestCreate.getPhone())
                .birthDate(userRequestCreate.getBirthDate())
                .email(userRequestCreate.getEmail())
                .password(userRequestCreate.getPassword())
                .roles(userRequestCreate.getRoles())
                .build();

    }
}
