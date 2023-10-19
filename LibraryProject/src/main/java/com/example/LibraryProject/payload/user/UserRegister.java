package com.example.LibraryProject.payload.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;



@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserRegister {


    @NotNull(message = "First name must not be empty")
    @Size(min=2, max=30)
    private String firstName;

    @NotNull(message = "Last name must not be empty")
    @Size(min=2, max=30)
    private String lastName;


    @NotNull(message = "Address must not be empty")
    @Size(min = 10, max = 100)
    private String address;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddd-ddd-dddd") //todo format phone number kısmı
    private String phone;

    @Column(nullable = true)
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotNull(message = "Email must not be empty")
    @Size(min=10, max=80)
    @Email
    private String email;

    @NotNull(message = "Password must not be empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
