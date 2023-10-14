package com.example.LibraryProject.payload.user;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserRequestForSignin {
    private String email;

    private String password;
}
