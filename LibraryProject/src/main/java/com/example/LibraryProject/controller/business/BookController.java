package com.example.LibraryProject.controller.business;

import com.example.LibraryProject.service.business.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;


    // * NOT : saveBooks() ******************** POST - Admin

    // * NOT : getBooksByPageable() ******************** GET - Tüm roller

    // * NOT : getBookById() ******************** GET - Tüm roller

    // * NOT : updateBooksById() ******************** PUT - Admin

    // * NOT : deleteBooksById() ******************** DELETE - Admin


}
