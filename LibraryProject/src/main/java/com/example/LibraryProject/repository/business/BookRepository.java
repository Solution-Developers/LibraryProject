package com.example.LibraryProject.repository.business;

import com.example.LibraryProject.entity.business.Book;
import com.example.LibraryProject.payload.business.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.DoubleStream;

public interface BookRepository extends JpaRepository<Book, Long> {


    //TODO: Kitap ismine göre de yazilmasi gerek
    @Query("SELECT b FROM Book b\n" +
            "WHERE b.categoryId LIKE :categoryId\n" +
            "   OR b.authorId LIKE :authorId\n" +
            "   OR b.publisherId LIKE :publisherId")
    Page<Book> findByBookById(Long id, Pageable pageable);
}
