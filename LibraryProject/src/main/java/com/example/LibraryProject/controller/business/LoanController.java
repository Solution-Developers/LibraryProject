package com.example.LibraryProject.controller.business;

import com.example.LibraryProject.payload.business.response.BookResponse;
import com.example.LibraryProject.payload.business.response.LoanResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.service.business.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/loans/{id}")
     public ResponseEntity<LoanResponse> getBookWithId(@PathVariable Long id){

        return ResponseEntity.ok(loanService.getBookWithId(id));


    }





}
