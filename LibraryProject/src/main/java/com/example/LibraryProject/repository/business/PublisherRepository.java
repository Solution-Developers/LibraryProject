package com.example.LibraryProject.repository.business;

import com.example.LibraryProject.entity.business.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
    Publisher findByPublisherName(String name);
}
