package com.example.LibraryProject.payload.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserRequest {

    private String firstName;

    private String lastName;

    private Integer score;

    private String address;

    private String phone;

    private String email;

    private String password;

    private Long userId;



}
