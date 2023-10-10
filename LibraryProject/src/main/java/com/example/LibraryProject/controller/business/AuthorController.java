package com.example.LibraryProject.controller.business;

import com.example.LibraryProject.service.business.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;


    // * NOT : saveAuthors() ******************** POST - Admin

    // * NOT : getAllAuthorsByPageable() ******************** GET - Anonymous

    // * NOT : getAuthorsById() ******************** GET - Anonymous

    // * NOT : updateAuthorsById() ******************** PUT - Admin

    // * NOT : deleteAuthorsById() ******************** DELETE - Admin
}
