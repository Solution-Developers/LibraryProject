package com.example.LibraryProject.repository.user;

import com.example.LibraryProject.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
