package com.example.LibraryProject.repository.user;

import com.example.LibraryProject.entity.enums.RoleType;
import com.example.LibraryProject.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query(value = "SELECT COUNT(r) FROM Role r WHERE r.roleName = ?1")
    long countAdmin(RoleType roleType);
}
