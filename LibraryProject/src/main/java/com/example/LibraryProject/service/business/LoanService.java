package com.example.LibraryProject.service.business;

import com.example.LibraryProject.entity.business.Book;
import com.example.LibraryProject.entity.business.Loan;
import com.example.LibraryProject.entity.user.User;
import com.example.LibraryProject.exception.BadRequestException;
import com.example.LibraryProject.exception.ResourceNotFoundException;
import com.example.LibraryProject.payload.business.request.LoanRequest;
import com.example.LibraryProject.payload.business.request.abstracts.BookRequestSave;
import com.example.LibraryProject.payload.business.request.abstracts.BookRequestUpdate;
import com.example.LibraryProject.payload.business.response.BookResponse;
import com.example.LibraryProject.payload.business.response.LoanResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.payload.mapper.BookMapper;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final PageableHelper pageableHelper;
    private final LoanMapper loanMapper;
    private final LoanHelper loanHelper;
    private final BookService bookService;


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
    public ResponseMessage<LoanResponse> saveLoan(LoanRequest loanRequest) {
        loanHelper.isLoanExistById(loanRequest.getLoanId());
        Boolean user = loanRepository.existsById(loanRequest.getUser().getId());
        Boolean book = loanRepository.existsById(loanRequest.getBookId());
        int userScore = loanRequest.getUser().getScore();
        List<Loan> loanList = loanRequest.getUser().getLoanList();

        if (user.equals(Boolean.FALSE)){
            throw  new ResourceNotFoundException(ErrorMessages.NOT_FOUND_USER);
        }
        if (book.equals(Boolean.FALSE)){
            throw new ResourceNotFoundException(ErrorMessages.NOT_FOUND_BOOK);
        }
        //? book da is available field yok.
        //! if book is available loan can ve created otherwise return object {isAvailable:false}
        //--------------
        Boolean isItOverDue =loanRepository.findOverDueLoans(loanRequest.getUser().getId());
        if (isItOverDue.equals(Boolean.TRUE)){
            throw new BadRequestException(ErrorMessages.OVERDUE_LOAN_DATE);
            //? body e girildi ise user kitap alamaz.
            //* task de verilmemiş field
            /* !loanRequest.getUser().getCanTakeBook = false;*/
        }

        //---------------
        Loan savedLoan = loanRepository.save(createLoan(loanRequest));

        if ((userScore > 2)|| (userScore == 2)){
            if (loanList.size()<6){
            loanList.add(createLoan(loanRequest).toBuilder()
                    .returnDate(loanRequest.getReturnDate().plusDays(20))
                    .build());
            }else {
                throw new BadRequestException(String.format(ErrorMessages.LOAN_BOOKLIST_SIZE_EXCEPTION,5));
            }
        }
        if (userScore == 1){
            if (loanList.size()<5){
                loanList.add(createLoan(loanRequest).toBuilder()
                        .returnDate(loanRequest.getReturnDate().plusDays(15))
                        .build());
            }else {
                throw new BadRequestException(String.format(ErrorMessages.LOAN_BOOKLIST_SIZE_EXCEPTION,4));
            }
        }
        if (userScore == 0 ){
            if (loanList.size()<4){
                loanList.add(createLoan(loanRequest).toBuilder()
                        .returnDate(loanRequest.getReturnDate().plusDays(10))
                        .build());
            }else {
                throw new BadRequestException(String.format(ErrorMessages.LOAN_BOOKLIST_SIZE_EXCEPTION,2));
            }
        }
        if (userScore == -1 ){
            if (loanList.size()<3){
                loanList.add(createLoan(loanRequest).toBuilder()
                        .returnDate(loanRequest.getReturnDate().plusDays(6))
                        .build());
            }else {
                throw new BadRequestException(String.format(ErrorMessages.LOAN_BOOKLIST_SIZE_EXCEPTION,1));
            }
        }
        if ((userScore < -2)|| (userScore == -2)){
            if (loanList.isEmpty() || loanList.size()<2){
                loanList.add(createLoan(loanRequest).toBuilder()
                        .returnDate(loanRequest.getReturnDate().plusDays(3))
                        .build());
            }else {
                throw new BadRequestException(String.format(ErrorMessages.LOAN_BOOKLIST_SIZE_EXCEPTION,7))
            }
        }

        return ResponseMessage.<LoanResponse>builder()
                .object(loanMapper.mapLoanToLoanResponse(savedLoan))
                .message(SuccessMessages.LOAN_SAVED)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    private Loan createLoan(LoanRequest loanRequest){
        return Loan.builder()
                .id(loanRequest.getLoanId())
                .userId(loanRequest.getUser().getId())
                .user(loanRequest.getUser())
                .bookId(loanRequest.getBookId())
                .loanDate(loanRequest.getLoanDate())
                .expireDate(loanRequest.getExpireDate())
                .returnDate(loanRequest.getReturnDate())
                .notes(loanRequest.getNotes())
                .build();
    }
    //---------------------------------------------------------
    //It will update the loan
    public ResponseEntity<LoanResponse> updateLoan(LoanRequest loanRequest) {
        loanHelper.isLoanExistById(loanRequest.getLoanId());

    }
}
