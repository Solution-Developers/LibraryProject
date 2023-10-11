package com.example.LibraryProject.controller.business;

import com.example.LibraryProject.payload.business.response.LoanResponse;
import com.example.LibraryProject.service.business.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

   // It will return own loans of authenticated user
    @GetMapping("/loans")
    public  Page<LoanResponse> getBorrowingBooks(@RequestParam(value = "page") int page,
                                                 @RequestParam(value = "size") int size,
                                                 @RequestParam(value = "sort") String sort,
                                                 @RequestParam(value = "type") String type){
        return LoanService.getBorrowingBooks(page,size,sort,type);

    }

}
