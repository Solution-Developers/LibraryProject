package com.example.LibraryProject.repository.business;

import com.example.LibraryProject.entity.business.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean isCategoryExistByName(String categoryName);

    boolean existsCategoryByCategoryNameEqualsIgnoreCase(String categoryName);
}
