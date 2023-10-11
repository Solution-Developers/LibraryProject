package com.example.LibraryProject.repository.business;

import com.example.LibraryProject.entity.business.Loan;
import com.example.LibraryProject.payload.business.response.LoanResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LoanRepository extends JpaRepository <Loan,Long>{
    @Query()
    Page<LoanResponse> getAllByLoan();


}
