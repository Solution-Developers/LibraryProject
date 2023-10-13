package com.example.LibraryProject.repository.user;

import com.example.LibraryProject.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
