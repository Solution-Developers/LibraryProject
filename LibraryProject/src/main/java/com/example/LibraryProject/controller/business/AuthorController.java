package com.example.LibraryProject.controller.business;

import com.example.LibraryProject.payload.business.request.AuthorRequest;
import com.example.LibraryProject.payload.business.response.AuthorResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.service.business.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;


    // * NOT : saveAuthors() ******************** POST - Admin
    @PostMapping("/save")
    public ResponseMessage<AuthorResponse> saveAuthor(@RequestBody @Valid AuthorRequest authorRequest){

        return authorService.saveAuthor(authorRequest);
    }

    // * NOT : getAllAuthorsByPageable() ******************** GET - Anonymous

    @GetMapping
    public Page<AuthorResponse> getAllAuthorsByPage(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size,
            @RequestParam(value = "sort") String sort,
            @RequestParam(value = "type") String type
    ){
        return authorService.getAllAuthorsByPage(page,size,sort,type);
    }

    // * NOT : getAuthorsById() ******************** GET - Anonymous
    @GetMapping("/{id}")
    public AuthorResponse getAuthorById(@PathVariable Long id){

        return authorService.getAuthorById(id);
    }

    // * NOT : updateAuthorsById() ******************** PUT - Admin

    // * NOT : deleteAuthorsById() ******************** DELETE - Admin
}
