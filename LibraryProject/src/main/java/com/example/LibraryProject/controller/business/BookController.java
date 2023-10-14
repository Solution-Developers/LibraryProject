package com.example.LibraryProject.controller.business;

import com.example.LibraryProject.payload.business.request.abstracts.BookRequestSave;
import com.example.LibraryProject.payload.business.response.BookResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.service.business.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
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
    public ResponseMessage<BookResponse> saveBook(@RequestBody @Valid BookRequestSave bookRequest){

        return bookService.saveBook(bookRequest);
    }

    // * NOT : getBooksByPageable() ******************** GET - Tüm roller
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','MEMBER','EMPLOYEE','ANONYMOUS')")
    public Page<BookResponse> getAllBooksByPageWithId(
            @PathVariable Long id,
            //TODO: kitap ismi için de bir degisken yazilacak
            @RequestParam(value = "page",defaultValue ="0" ) int page,
            @RequestParam(value = "size" , defaultValue = "20") int size,
            @RequestParam(value = "sort" , defaultValue = "name") String sort,
            @RequestParam(value = "type",defaultValue = "asc") String type
    ){

        return bookService.getAllBooksByPage(id,page,size,sort,type);
    }


    // * NOT : getBookById() ******************** GET - Tüm roller
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','MEMBER','EMPLOYEE','ANONYMOUS')")
    public BookResponse getBookById(@PathVariable Long bookId){

        return bookService.getBookById(bookId);
    }

    // * NOT : updateBooksById() ******************** PUT - Admin



    // * NOT : deleteBooksById() ******************** DELETE - Admin
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseMessage deleteBookById(@PathVariable Long bookId){

        return bookService.deleteBookById(bookId);
    }



}
