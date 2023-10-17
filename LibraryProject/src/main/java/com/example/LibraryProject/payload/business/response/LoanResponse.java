package com.example.LibraryProject.payload.business.response;

import com.example.LibraryProject.entity.business.Book;
import com.example.LibraryProject.entity.user.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanResponse {

    private Long loanId;

    private Long userId;

    private Long bookId;

    private LocalDateTime loanDate;

    private LocalDateTime expireDate;

    private LocalDateTime returnDate;

    private String notes;

    private List<Book> bookList;

    private User user;



}
