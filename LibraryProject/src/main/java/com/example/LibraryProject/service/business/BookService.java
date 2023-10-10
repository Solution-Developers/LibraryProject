package com.example.LibraryProject.service.business;

import com.example.LibraryProject.controller.business.BookController;
import com.example.LibraryProject.repository.business.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookController bookController;
    private final BookRepository bookRepository;

}
