package com.example.LibraryProject.controller.business;

import com.example.LibraryProject.entity.business.Loan;
import com.example.LibraryProject.payload.business.request.LoanRequest;
import com.example.LibraryProject.payload.business.request.abstracts.BookRequestSave;
import com.example.LibraryProject.payload.business.request.abstracts.BookRequestUpdate;
import com.example.LibraryProject.payload.business.response.BookResponse;
import com.example.LibraryProject.payload.business.response.LoanResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.payload.user.UserRequest;
import com.example.LibraryProject.service.business.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

   // It will return own loans of authenticated
    @PreAuthorize("hasAnyAuthority('Member')")
    @GetMapping("/loans")
    public  Page<LoanResponse> getBorrowingBooks(@RequestParam(value = "page") int page,
                                                 @RequestParam(value = "size") int size,
                                                 @RequestParam(value = "sort") String sort,
                                                 @RequestParam(value = "type") String type){
        return loanService.getBorrowingBooks(page,size,sort,type);
    }

    //It will return details of a loan of authenticated user
    @PreAuthorize("hasAnyAuthority('Member')")
    @GetMapping("/{id}")
     public ResponseEntity<LoanResponse> getBookWithId(@PathVariable Long id){

        return ResponseEntity.ok(loanService.getBookWithId(id));
    }
    //---------------------------------------------------------
    //It will return loans of specified user by id
    @PreAuthorize("hasAnyAuthority('EMPLOYEE,ADMIN')")
    @GetMapping("/user/{userId}")
    public Page<LoanResponse> getLoanWithUserId(
            @PathVariable Long userId,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size,
            @RequestParam(value = "sort") String sort,
            @RequestParam(value = "type") String type
    ){

        return loanService.getLoanWithUserId(userId,userRequest,page,size,sort,type);
    }
    //---------------------------------------------------------
    //It will return loans of specified book by id
    @PreAuthorize("hasAnyAuthority('EMPLOYEE,ADMIN')")
    @GetMapping("/book/{bookId}")
    public Page<LoanResponse> getLoanWithBookId( @PathVariable Long bookId,
                                                 @RequestParam(value = "page") int page,
                                                 @RequestParam(value = "size") int size,
                                                 @RequestParam(value = "sort") String sort,
                                                 @RequestParam(value = "type") String type)
    {
        return loanService.getLoanWithBookId(bookId,page,size,sort,type);
    }
    //---------------------------------------------------------
    //It will return details of a loan of any user
    @PreAuthorize("hasAnyAuthority('EMPLOYEE','ADMIN')")
    @GetMapping("/auth/{loanId}")
    public ResponseEntity<LoanResponse> getLoanWithLoanId(@PathVariable Long loanId){
        return ResponseEntity.ok(loanService.getLoanWithLoanId(loanId));
    }
    //---------------------------------------------------------
    //It will create a loan
    @PreAuthorize("hasAnyAuthority('EMPLOYEE','ADMIN')")
    @PostMapping("/saveLoans")
    public ResponseMessage<LoanResponse> saveLoan(@RequestBody @Valid LoanRequest loanRequest){
        return loanService.saveLoan(loanRequest);
    }
    //---------------------------------------------------------
    //It will update the loan
    @PreAuthorize("hasAnyAuthority('EMPLOYEE','ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<LoanResponse> updateLoan(@RequestBody @Valid LoanRequest loanRequest){
        return loanService.updateLoan(loanRequest);

    }










}
