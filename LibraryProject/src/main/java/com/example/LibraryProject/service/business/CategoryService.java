package com.example.LibraryProject.service.business;

import com.example.LibraryProject.controller.business.CategoryController;
import com.example.LibraryProject.repository.business.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryController categoryController;
}
