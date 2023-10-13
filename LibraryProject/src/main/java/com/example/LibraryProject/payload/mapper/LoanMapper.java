package com.example.LibraryProject.payload.mapper;

import com.example.LibraryProject.entity.business.Loan;
import com.example.LibraryProject.payload.business.request.LoanRequest;
import com.example.LibraryProject.payload.business.response.LoanResponse;
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

    public  LoanResponse mapLoanToLoanResponse(Loan loan){

        return LoanResponse.builder()
                .loanDate(loan.getLoanDate())
                .expireDate(loan.getExpireDate())
                .returnDate(loan.getReturnDate())
                .notes(loan.getNotes())
                .build();
    }

    public LoanResponse mapLoanToLoanResponseWithoutNotes(Loan loan){
        return  LoanResponse.builder()
                .loanDate(loan.getLoanDate())
                .expireDate(loan.getExpireDate())
                .returnDate(loan.getReturnDate())
                .build();
    }


}
