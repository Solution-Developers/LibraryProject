package com.example.LibraryProject.service.user;

import com.example.LibraryProject.entity.enums.RoleType;
import com.example.LibraryProject.entity.user.Role;
<<<<<<< HEAD
import com.example.LibraryProject.entity.user.User;
=======
>>>>>>> main
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

    public long countAllAdmins() {
        return roleRepository.countAdmin(RoleType.ADMIN);
    }

}
