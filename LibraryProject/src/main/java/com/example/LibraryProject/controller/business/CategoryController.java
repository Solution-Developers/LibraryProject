package com.example.LibraryProject.controller.business;

import com.example.LibraryProject.service.business.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    // * NOT : saveCategories() ******************** POST - Admin

    // * NOT : getCategoriesByPageable() ******************** GET - Anonymous

    // * NOT : getCategoriesById() ******************** GET - Anonymous

    // * NOT : updateCategoriesById() ******************** PUT - Admin

    // * NOT : deleteCategoriesById() ******************** DELETE - Admin



}
