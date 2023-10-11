package com.example.LibraryProject.payload.mapper;

import com.example.LibraryProject.entity.business.Loan;
import com.example.LibraryProject.payload.business.request.LoanRequest;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public Loan mapLoanRequestToLoan(LoanRequest loanRequest){

    return Loan.builder()
            .loanDate(loanRequest.getLoanDate())
            .expireDate(loanRequest.getExpireDate())
            .returnDate(loanRequest.getReturnDate())
            .notes(loanRequest.getNotes())
            .build();
    }
}
