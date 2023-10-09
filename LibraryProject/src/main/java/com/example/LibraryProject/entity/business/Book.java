package com.example.LibraryProject.entity.business;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;
import java.time.LocalDateTime;

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

    private Long authorId;

    private Long publisherId;

    private int publishDate;

    private Long categoryId;

    private File image;

    private boolean loanable;

    private String shelfCode;

    private boolean active;

    private boolean featured;

    private LocalDateTime createDate;

    private boolean builtIn;
}
