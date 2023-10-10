package com.example.LibraryProject.controller.business;

import com.example.LibraryProject.service.business.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/catagories")
public class CategoryController {
    private final CategoryService categoryService;
}
