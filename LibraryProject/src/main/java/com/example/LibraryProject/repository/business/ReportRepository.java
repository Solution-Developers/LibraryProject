package com.example.LibraryProject.repository.business;

import com.example.LibraryProject.entity.business.Reports;
import com.example.LibraryProject.payload.business.response.ReportResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ReportRepository extends JpaRepository<Reports,Long> {

    @Query("SELECT COUNT (b) FROM Book b")
    Integer getBookCount();
    @Query("SELECT COUNT (a) FROM Author a")
    Integer getAuthorCount();
    @Query("SELECT COUNT (p) FROM Publisher p")
    Integer getPublishersCount();
    @Query("SELECT COUNT (c) FROM Category c")
    Integer getCategoriesCount();
    @Query("SELECT COUNT (l) FROM Loan l")
    Integer getLoanCount();
    @Query("SELECT COUNT (b) FROM Book b ")
    Integer getUnreturnedBookCount();
    Integer getExpiredBookCount();
    Integer getMemberCount();

}
