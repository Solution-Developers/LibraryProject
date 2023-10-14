package com.example.LibraryProject.service.helper;

import com.example.LibraryProject.entity.business.Book;
import com.example.LibraryProject.exception.ResourceNotFoundException;
import com.example.LibraryProject.payload.message.ErrorMessages;
import com.example.LibraryProject.repository.business.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookHelper {
    private final BookRepository bookRepository;

    public Book isBookExistById (Long bookId){

        return bookRepository.findById(bookId).orElseThrow(()->

                new ResourceNotFoundException(String.format(ErrorMessages.NOT_FOUND_BOOK, bookId)));


    }
}
