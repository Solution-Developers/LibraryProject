package com.example.LibraryProject.repository.business;


import com.example.LibraryProject.entity.business.Loan;

import com.example.LibraryProject.payload.user.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface LoanRepository extends JpaRepository <Loan,Long>{

    Loan getById(Long id);

    @Query("SELECT l FROM Loan l WHERE l.bookId=?1")
    Page<Loan> getLoanByBookId(Long bookId, Pageable pageable);

    @Query("SELECT l FROM Loan l WHERE l.userId=?1")
    Page<Loan> getLoanByUserId(Long userId,Pageable pageable);

    @Query("SELECT l FROM Loan l WHERE l.userId=?1 and l.returnDate IS NULL")
    Boolean findOverDueLoans(Long userId);
}
