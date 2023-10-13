package com.example.LibraryProject.payload.mapper;

import com.example.LibraryProject.entity.business.Book;
import com.example.LibraryProject.payload.business.request.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapper {

    public Book mapRequestToBook(BookRequest bookRequest){

        return null;
    }
}
