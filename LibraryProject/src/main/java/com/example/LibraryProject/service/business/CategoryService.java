package com.example.LibraryProject.service.business;

import com.example.LibraryProject.entity.business.Category;
import com.example.LibraryProject.exception.ConflictException;
import com.example.LibraryProject.payload.business.request.CategoryRequest;
import com.example.LibraryProject.payload.business.response.CategoryResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.payload.mapper.CategoryMapper;
import com.example.LibraryProject.payload.message.ErrorMessages;
import com.example.LibraryProject.payload.message.SuccessMessages;
import com.example.LibraryProject.repository.business.CategoryRepository;
import com.example.LibraryProject.service.helper.CategoryHelper;
import com.example.LibraryProject.service.helper.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final PageableHelper pageableHelper;
    private final CategoryMapper categoryMapper;
    private final CategoryHelper categoryHelper;
    private final Category category;


    // * NOT : saveCategories() *************
    public ResponseMessage<CategoryResponse> saveCategory(CategoryRequest categoryRequest) {
        isCategoryExistByName(categoryRequest.getCategoryName());

        Category saveCategory = categoryRepository.save(mapCategoryRequestToCategory(categoryRequest));


        return ResponseMessage.<CategoryResponse>builder()
                .object(categoryMapper.mapCategoryToCategoryResponse(saveCategory))
                .httpStatus(HttpStatus.OK)
                .message(SuccessMessages.CATEGORY_CREATED)
                .build();
    }

    private boolean isCategoryExistByName(String categoryName){
        boolean existCategory = categoryRepository.isCategoryExistByName(categoryName);
        if (existCategory) {
            throw new ConflictException(String.format(ErrorMessages.CATEGORY_ALREADY_EXIST, categoryName));
        }else{
            return false;
        }
    }
    private Category mapCategoryRequestToCategory(CategoryRequest categoryRequest){
        return Category.builder()
                .name(categoryRequest.getCategoryName())
                .build();


    }

    // * NOT : getCategoriesByPageable() **********
    public Page<CategoryResponse> getAllCategryByPage(int page, int size, String sort, String type) {
        Pageable pageable = getPageableWithProperties(page, size, sort, type);
        return categoryRepository.findAll(pageable).map(this::mapCategoryToCategoryResponse);
    }



    private Pageable getPageableWithProperties(int page, int size, String sort, String type) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort).ascending());
        if (Objects.equals(type, "desc")) {
            pageable = PageRequest.of(page, size, Sort.by(sort).descending());
        }
        return pageable;
    }

    // * NOT : getCategoriesById() ********
    public ResponseMessage<CategoryResponse> getCategoryById(Long id) {
        return ResponseMessage.<CategoryResponse>builder()
                .httpStatus(HttpStatus.OK)
                .object(mapCategoryToCategoryResponse(categoryHelper.isCategoryExistById(id)))
                .build();


    }

    // * NOT : updateCategoriesById() *********
    public ResponseMessage<CategoryResponse> updateCategoryById(Long id, CategoryRequest categoryRequest) {
        Category category = categoryHelper.isAuthorExistById(id);
        if (
                !(category.getName().equals(categoryRequest.getCategoryName())) &&
                        (categoryRepository.existsCategoryByCategoryNameEqualsIgnoreCase(categoryRequest.getCategoryName())) // Derived Query
        ) {
            throw new ConflictException(String.format(ErrorMessages.CATEGORY_ALREADY_EXIST,categoryRequest.getCategoryName()));
        }

        Category updatedCategory = categoryMapper.mapCategoryToUpdateRequest(categoryRequest, id);

        Category savedCategory = categoryRepository.save(updatedCategory);

        return ResponseMessage.<CategoryResponse>builder()
                .message(SuccessMessages.CATEGORY_UPDATED)
                .httpStatus(HttpStatus.OK)
                .object(mapCategoryToCategoryResponse(savedCategory))
                .build();

    }

    private CategoryResponse mapCategoryToCategoryResponse(Category savedCategory) {
        return CategoryResponse.builder()
                .categoryName(category.getName())
                .build();
    }

    // * NOT : deleteCategoriesById() ****** Category category
    public ResponseMessage deleteCategoryById(Long id) {
        categoryHelper.isAuthorExistById(id);
        categoryRepository.deleteById(id);

        return ResponseMessage.builder()
                .message(SuccessMessages.CATEGORY_DELETE)
                .httpStatus(HttpStatus.OK)
                .build();
    }
}
