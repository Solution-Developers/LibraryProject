package com.example.LibraryProject.service.business;

import com.example.LibraryProject.entity.business.Loan;
import com.example.LibraryProject.entity.user.User;
import com.example.LibraryProject.exception.ResourceNotFoundException;
import com.example.LibraryProject.payload.business.request.LoanRequest;
import com.example.LibraryProject.payload.business.request.abstracts.BookRequestSave;
import com.example.LibraryProject.payload.business.request.abstracts.BookRequestUpdate;
import com.example.LibraryProject.payload.business.response.BookResponse;
import com.example.LibraryProject.payload.business.response.LoanResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.payload.mapper.LoanMapper;
import com.example.LibraryProject.payload.message.ErrorMessages;
import com.example.LibraryProject.payload.message.SuccessMessages;
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

import javax.validation.constraints.Null;
import java.util.List;

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

    public Page<LoanResponse> getLoanWithUserId(Long userId, int page, int size, String sort, String type) {

        Pageable pageable = pageableHelper.getPageableWithProperties(page,size,sort,type);
        return loanRepository.getLoanByBookId(userId,pageable).map(loanMapper::mapForUserLoanToLoanResponseWithNotes);

    }

//---------------------------------------------------------
//It will return loans of specified book by id
    public Page<LoanResponse> getLoanWithBookId(Long bookId, int page, int size, String sort, String type) {
        Pageable pageable = pageableHelper.getPageableWithProperties(page,size,sort,type);
        return loanRepository.getLoanByBookId(bookId,pageable).map(loanMapper::mapLoanToLoanResponse);
    }
    //---------------------------------------------------------
    //It will return details of a loan of any user
    public LoanResponse getLoanWithLoanId(Long loanId) {
        loanHelper.isLoanExistById(loanId);
        return loanMapper.mapLoanToLoanResponse(loanRepository.getById(loanId));
    }

    //---------------------------------------------------------
    //It will create a loan
    public ResponseMessage<LoanResponse> saveLoan(UserRequest userRequest, BookRequestSave bookRequest, LoanRequest loanRequest) {
        loanHelper.isLoanExistById(loanRequest.getLoanId());

        if (Boolean.FALSE.equals(bookRequest.getActive())){
            bookRequest.setActive(false);
        }


        Boolean overDueLoans = loanRepository.findOverDueLoans(userRequest.getUserId());
        if (Boolean.TRUE.equals(overDueLoans)){
            // ise user ın kitap alamaz bunu nasıl yaparım anlamadım.
        //todo : eğerki user aldıgı kitapları vermemiş ise kitap alamaz.
        }

        if (userRequest.getScore().equals(0)){
            //todo :score a göre alınan kitapları sınırlandırma
        }




        Loan savedLoan = loanRepository.save(loanMapper.mapLoanRequestToLoan(loanRequest));
        return ResponseMessage.<LoanResponse>builder()
                .object(loanMapper.mapLoanToLoanResponse(savedLoan))
                .message(SuccessMessages.LOAN_SAVED)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    //---------------------------------------------------------
    //It will update the loan
    public ResponseEntity<LoanResponse> updateLoan(LoanRequest loanRequest, BookRequestUpdate bookRequest) {
        loanHelper.isLoanExistById(loanRequest.getLoanId());





    }
}
