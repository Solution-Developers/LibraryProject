package com.example.LibraryProject.service.business;

import com.example.LibraryProject.controller.business.AuthorController;
import com.example.LibraryProject.repository.business.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorController authorController;
    private final AuthorRepository authorRepository;
}
