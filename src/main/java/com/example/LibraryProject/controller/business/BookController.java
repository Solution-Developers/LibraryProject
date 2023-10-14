package com.example.LibraryProject.controller.business;

import com.example.LibraryProject.payload.business.request.BookRequest;
import com.example.LibraryProject.payload.business.response.BookResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.service.business.BookService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;


    // * NOT : saveBooks() ******************** POST - Admin
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseMessage<BookResponse> saveBook(@RequestBody @Valid BookRequest bookRequest){

        return bookService.saveBook(bookRequest);
    }

    // * NOT : getBooksByPageable() ******************** GET - Tüm roller





    // * NOT : getBookById() ******************** GET - Tüm roller
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','MEMBER','EMPLOYEE','ANONYMOUS')")
    public ResponseMessage<BookResponse> getBookById(@PathVariable Long bookId){

        return bookService.getBookById(bookId);
    }

    // * NOT : updateBooksById() ******************** PUT - Admin





    // * NOT : deleteBooksById() ******************** DELETE - Admin





}
