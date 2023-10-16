package com.example.LibraryProject.entity.business;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String isbn;

    private int pageCount;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private Long authorId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Long publisherId;

    private int publishDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Long categoryId;

    private File image;

    private boolean loanable;

    private String shelfCode;

    private boolean active;

    private boolean featured;

    private LocalDateTime createDate;

    private boolean builtIn;

    @OneToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private List<Loan> loans;


}
