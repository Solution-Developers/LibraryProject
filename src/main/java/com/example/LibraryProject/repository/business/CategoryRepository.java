package com.example.LibraryProject.repository.business;

import com.example.LibraryProject.entity.business.Category;
import com.example.LibraryProject.payload.business.request.CategoryRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean isCategoryExistByName(String categoryName);

    public void mapCategoryRequestToCategory(CategoryRequest categoryRequest);

    public void mapCategoryToCategoryResponse(CategoryRequest categoryRequest);

    boolean existsCategoryByCategoryNameEqualsIgnoreCase(String categoryName);
}
