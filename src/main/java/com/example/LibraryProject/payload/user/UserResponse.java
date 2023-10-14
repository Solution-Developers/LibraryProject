package com.example.LibraryProject.payload.user;

import com.example.LibraryProject.entity.business.Loan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserResponse {

    private String firstName;

    private String lastName;

    private Integer score; //! int demiş klavuzda

    private String address;

    private String phone;

    private LocalDate birthDate;

    private String email;

    private List<Loan> loanList;


}
