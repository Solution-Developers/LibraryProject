package com.example.LibraryProject.repository.business;

import com.example.LibraryProject.entity.business.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatagoryRepository extends JpaRepository<Category, Long> {
}
