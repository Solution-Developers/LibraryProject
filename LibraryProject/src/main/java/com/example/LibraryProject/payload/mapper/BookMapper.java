package com.example.LibraryProject.payload.mapper;

import com.example.LibraryProject.entity.business.Book;
import com.example.LibraryProject.payload.business.request.abstracts.BookRequestUpdate;
import com.example.LibraryProject.payload.business.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapper {

    public Book mapRequestToBook(BookRequestUpdate bookRequest){

        return null;
    }

    public BookResponse mapBookToBookResponse(Book book){

        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .isbn(book.getIsbn())
                .build();
    }
}
