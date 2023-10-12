package com.example.LibraryProject.service.business;

import com.example.LibraryProject.payload.business.response.BookResponse;
import com.example.LibraryProject.payload.business.response.LoanResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.payload.mapper.LoanMapper;
import com.example.LibraryProject.repository.business.LoanRepository;
import com.example.LibraryProject.service.helper.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final PageableHelper pageableHelper;
    private final LoanMapper loanMapper;



    public  Page<LoanResponse> getBorrowingBooks(int page, int size, String sort, String type) {

       Pageable pageable =pageableHelper.getPageableWithProperties(page, size, sort, type);

      return loanRepository.getAllByLoan().map(loanMapper::mapLoanToLoanResponse);


    }

    public LoanResponse getBookWithId(Long id) {
        return loanMapper.mapLoanToLoanResponse(loanRepository.getById(id)) ;


    }
}
