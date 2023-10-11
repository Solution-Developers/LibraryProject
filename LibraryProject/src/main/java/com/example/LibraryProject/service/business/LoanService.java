package com.example.LibraryProject.service.business;

import com.example.LibraryProject.payload.business.response.LoanResponse;
import com.example.LibraryProject.repository.business.LoanRepository;
import com.example.LibraryProject.service.helper.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final PageableHelper pageableHelper;



    public  Page<LoanResponse> getBorrowingBooks(int page, int size, String sort, String type) {

       Pageable pageable =pageableHelper.getPageableWithProperties(page, size, sort, type);

       return loanRepository.;


    }
}
