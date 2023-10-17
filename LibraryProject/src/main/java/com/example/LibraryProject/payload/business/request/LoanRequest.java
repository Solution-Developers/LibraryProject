package com.example.LibraryProject.payload.business.request;


import com.example.LibraryProject.entity.business.Book;
import com.example.LibraryProject.entity.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LoanRequest {



    @NotNull(message = "loanDate must not be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,'T' HH:mm:ss",timezone = "UTC")
    private LocalDateTime loanDate;

    @NotNull(message ="expireDate must not be empty" )
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,'T' HH:mm:ss",timezone = "UTC")
    private LocalDateTime expireDate;

    @NotNull(message = "returnDate must not be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,'T' HH:mm:ss",timezone = "UTC")
    private LocalDateTime returnDate;

    @Nullable()
    private String notes;

    private Long loanId;

    @ManyToMany(mappedBy = "loans", cascade = CascadeType.ALL)
    private List<Book> bookList;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @NotNull
    private Long bookId;

    private Book book;





}
