package com.example.LibraryProject.service.helper;

import com.example.LibraryProject.entity.business.Loan;
import com.example.LibraryProject.exception.ResourceNotFoundException;
import com.example.LibraryProject.payload.business.request.LoanRequest;
import com.example.LibraryProject.payload.message.ErrorMessages;
import com.example.LibraryProject.repository.business.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoanHelper {

    private final LoanRepository loanRepository;

    public Loan isLoanExistById(Long id){
        return  loanRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessages.NOT_FOUND_LOAN,id)));
    }

}
