package com.example.LibraryProject.payload.user;

import com.example.LibraryProject.entity.business.Loan;
import com.example.LibraryProject.entity.user.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


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
