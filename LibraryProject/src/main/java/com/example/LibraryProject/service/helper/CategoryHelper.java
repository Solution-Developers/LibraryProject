package com.example.LibraryProject.service.helper;

import com.example.LibraryProject.entity.business.Category;
import com.example.LibraryProject.exception.ConflictException;
import com.example.LibraryProject.exception.ResourceNotFoundException;
import com.example.LibraryProject.payload.business.request.CategoryRequest;
import com.example.LibraryProject.payload.message.ErrorMessages;
import com.example.LibraryProject.repository.business.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryHelper {
    private final CategoryRepository categoryRepository;


    public Category isAuthorExistById(Long id){

        return categoryRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessages.NOT_FOUND_AUTHOR,id)));
    }

    public Category mapCategoryRequestToCategory(CategoryRequest categoryRequest){
        return Category.builder()
                .name(categoryRequest.getCategoryName())
                .build();

    }

    public boolean isCategoryExistByCategoryName(String categoryName){
        boolean existCategory = categoryRepository.existsCategoryByCategoryNameEqualsIgnoreCase(categoryName);

        if (existCategory){
            throw new ConflictException(String.format(ErrorMessages.CATEGORY_ALREADY_EXIST, categoryName));
        }else {

            return false;

        }
    }

    public Category isCategoryExistById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessages.NOT_FOUND_CATEGORY,id)));

    }
}
