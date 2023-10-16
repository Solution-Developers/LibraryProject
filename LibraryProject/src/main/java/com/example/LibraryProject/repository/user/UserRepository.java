package com.example.LibraryProject.repository.user;


import com.example.LibraryProject.entity.user.User;
import com.example.LibraryProject.payload.user.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User,Long> {


    User findByEmail(String email);

    @Query("select u from User u where u.email =?1 ")
    Page<UserResponse> findByLoanListByPage(String email, Pageable pageable);


    User findByEmailEquals(String email);

    boolean existsByPhoneNumber(String phone);

    boolean existsByEmail(String email);
}
