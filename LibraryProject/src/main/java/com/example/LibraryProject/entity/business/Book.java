package com.example.LibraryProject.entity.business;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "t_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String isbn;

    private int pageCount;

    private Long authorId;

    private Long publisherId;  //yayinci

    private int publishDate;

    private Long categoryId;

    private File image;

    private boolean loanable; //Emanette mi? ödünç verilebilir

    private String shelfCode;  //raf Kodu

    private boolean active;    // elimizde var mi?

    private  boolean featured;  //öne çıkan

    private LocalDateTime createDate;

    private boolean builtIn;    //yerleşik/ silinememezlik
}
