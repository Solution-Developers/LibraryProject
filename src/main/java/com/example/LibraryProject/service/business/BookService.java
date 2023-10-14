package com.example.LibraryProject.service.business;

import com.example.LibraryProject.controller.business.BookController;
import com.example.LibraryProject.entity.business.Book;
import com.example.LibraryProject.payload.business.request.BookRequest;
import com.example.LibraryProject.payload.business.response.BookResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.repository.business.BookRepository;
import com.example.LibraryProject.service.helper.BookHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookHelper bookHelper;

    public ResponseMessage<BookResponse> saveBook(BookRequest bookRequest) {

        return null;
    }

    public ResponseMessage<BookResponse> getBookById(Long bookId) {
        Book book =bookHelper.isBookExistById(bookId);

        // TODO : Buraya bakilacak

        return null;
    }

}
