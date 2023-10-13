package com.example.LibraryProject.service.business;

import com.example.LibraryProject.entity.business.Loan;
import com.example.LibraryProject.entity.user.User;
import com.example.LibraryProject.exception.ResourceNotFoundException;
import com.example.LibraryProject.payload.business.request.LoanRequest;
import com.example.LibraryProject.payload.business.response.BookResponse;
import com.example.LibraryProject.payload.business.response.LoanResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.payload.mapper.LoanMapper;
import com.example.LibraryProject.payload.message.ErrorMessages;
import com.example.LibraryProject.payload.user.UserRequest;
import com.example.LibraryProject.repository.business.LoanRepository;
import com.example.LibraryProject.service.helper.LoanHelper;
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
    private final LoanHelper loanHelper;

    //---------------------------------------------------------
    //It will return own loans of authenticated user
    public  Page<LoanResponse> getBorrowingBooks(int page, int size, String sort, String type) {
       Pageable pageable =pageableHelper.getPageableWithProperties(page, size, sort, type);
      return loanRepository.findAll(pageable).map(loanMapper::mapLoanToLoanResponseWithoutNotes);
    }

    //---------------------------------------------------------
    //It will return own loans of authenticated user
    public LoanResponse getBookWithId(Long id) {
        return loanMapper.mapLoanToLoanResponse(loanRepository.getById(id)) ;
    }

    //---------------------------------------------------------
    //It will return loans of specified user by id

//todo ITS NEED USER REQUEST CLASS
//    public Page<LoanResponse> getLoanWithUserId(Long userId, UserRequest userRequest, int page, int size, String sort, String type) {
//        loanHelper.isLoanExistById(userId);
//        Pageable pageable = pageableHelper.getPageableWithProperties(page,size,sort,type);
//    }

//---------------------------------------------------------
//It will return loans of specified book by id
    public Page<LoanResponse> getLoanWithBookId(Long bookId, int page, int size, String sort, String type) {
        //todo: is book exists
//        *bookHelper.isBookExistsById(bookId);
        Pageable pageable = pageableHelper.getPageableWithProperties(page,size,sort,type);
        return loanRepository.getById()
    }
    //---------------------------------------------------------
    //It will return details of a loan of any user
    public ResponseEntity<LoanResponse> getLoanWithLoanId(Long loanId) {
    }

    //---------------------------------------------------------
    //It will create a loan
    public ResponseEntity<LoanResponse> saveLoan(UserRequest userRequest, BookRequest bookRequest, LoanRequest loanRequest) {
    }

    //---------------------------------------------------------
    //It will update the loan
    public ResponseEntity<LoanResponse> updateLoan(LoanRequest loanRequest) {

    }
}
