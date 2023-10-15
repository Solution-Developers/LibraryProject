package com.example.LibraryProject.payload.mapper;

import com.example.LibraryProject.entity.business.Category;
import com.example.LibraryProject.payload.business.request.CategoryRequest;
import com.example.LibraryProject.payload.business.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {
    public Category mapRequestToCategory(CategoryRequest categoryRequest){

        return Category.builder()
//                .name(categoryRequest.getCategoryName())
//                .creditScore(categoryRequest.getCreditScore())
//                .isCompulsory(categoryRequest.getIsCompulsory())
                .build();
    }

    public CategoryResponse mapCategoryToCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .categoryId(category.getId())
                .categoryName(category.getName())
//                .creditScore(category.getCreditScore())
//                .isCompulsory(category.getIsCompulsory())
                .build();
    }

    public Category mapCategoryToUpdateRequest(CategoryRequest categoryRequest, Long id) {
        return Category.builder()
//                .name(categoryRequest.getCategoryName())
//                .creditScore(categoryRequest.getCreditScore())
//                .isCompulsory(categoryRequest.getIsCompulsory())
                .build();

    }
}
