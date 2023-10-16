package com.example.LibraryProject.controller.business;

import com.example.LibraryProject.payload.business.request.CategoryRequest;
import com.example.LibraryProject.payload.business.response.CategoryResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.service.business.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    // * NOT : saveCategories() ******************** POST - Admin
    @PostMapping("/save")  //http://localhost:8080/categories/save
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseMessage<CategoryResponse> saveCategory(@RequestBody @Valid CategoryRequest categoryRequest){
        return categoryService.saveCategory(categoryRequest);
    }

    // * NOT : getCategoriesByPageable() ******************** GET - Anonymous
    @PreAuthorize("hasAnyAuthority('ANONYMOUS')")
    @GetMapping("/findCategoryByPage")        //http://localhost:8080/categories/findAuthorByPage
    public Page<CategoryResponse> getAllCategryByPage(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size,
            @RequestParam(value = "sort") String sort,
            @RequestParam(value = "type") String type
    ){
        return categoryService.getAllCategryByPage(page,size,sort,type);
    }

    // * NOT : getCategoriesById() ******************** GET - Anonymous
    @PreAuthorize("hasAnyAuthority('ANONYMOUS')")
    @GetMapping("/getCategoryById/{id}")    //http://localhost:8080/categories/getAuthorsById?AuthorId=1,2,3 + GET
    public ResponseMessage<CategoryResponse> getCategoryById(@PathVariable Long id){

        return categoryService.getCategoryById(id);
    }


    // * NOT : updateCategoriesById() ******************** PUT - Admin
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/update/{categoriesId}")        //http://localhost:8080/categories/update/3
    public ResponseMessage<CategoryResponse> updateCategoryById(@RequestBody CategoryRequest categoryRequest,
                                                                @PathVariable Long id)
    {
        return categoryService.updateCategoryById(id, categoryRequest);
    }


    // * NOT : deleteCategoriesById() ******************** DELETE - Admin
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")           // http://localhost:8080/categories/delete/3
    public ResponseMessage deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategoryById(id);
    }

}
