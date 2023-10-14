package com.example.LibraryProject.repository.business;

import com.example.LibraryProject.entity.business.Reports;
import com.example.LibraryProject.payload.business.response.ReportResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    @Query("SELECT COUNT (b) FROM Book b JOIN b.loans l WHERE l.returnDate IS null ")
    Integer getUnreturnedBookCount();
    @Query("SELECT COUNT (b) FROM Book b JOIN b.loans l WHERE l.expireDate > l.returnDate")
    Integer getExpiredBookCount();
    @Query("SELECT COUNT (u) FROM User u")
    Integer getMemberCount();

    @Query("SELECT b, COUNT(l) AS loans FROM Book b JOIN Loan l ON b.id = l.book.id GROUP BY b ORDER BY loans DESC LIMIT 20")
    Page<ReportResponse> findMostPopularBooks(Pageable pageable, @Param("size") int size);

    @Query("SELECT h, COUNT(y) AS loans FROM Book k JOIN Loan y ON k.id=y.book.id GROUP BY k ORDER BY loans DESC LIMIT 20")
    Page<ReportResponse>findUnreturnedBooks(Pageable pageable,@Param("size")int size);

     @Query("SELECT h, COUNT(y) AS loans FROM Book k JOIN Loan y ON k.id=y.book.id GROUP BY k ORDER BY loans DESC LIMIT 20")
    Page<ReportResponse> findExpiredBooks(Pageable pageable,@Param("size") int size);


      @Query("SELECT h, COUNT(y) AS loans FROM Book k JOIN Loan y ON k.id=y.book.id GROUP BY k ORDER BY loans DESC LIMIT 20")
    Page<ReportResponse> findMostBorrowers(Pageable pageable,@Param("size") int size);
}
