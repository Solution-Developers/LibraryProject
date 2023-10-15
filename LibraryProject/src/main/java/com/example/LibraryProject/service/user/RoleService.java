package com.example.LibraryProject.service.user;

import com.example.LibraryProject.entity.user.Role;
import com.example.LibraryProject.repository.user.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    public List<Role> getAllUserRole(){
        return roleRepository.findAll();
    }
}
