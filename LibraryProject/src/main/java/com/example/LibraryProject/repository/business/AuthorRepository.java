package com.example.LibraryProject.repository.business;

import com.example.LibraryProject.entity.business.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository <Author, Long>{
}
