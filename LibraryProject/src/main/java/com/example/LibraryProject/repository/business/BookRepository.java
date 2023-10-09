package com.example.LibraryProject.repository.business;

import com.example.LibraryProject.entity.business.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
