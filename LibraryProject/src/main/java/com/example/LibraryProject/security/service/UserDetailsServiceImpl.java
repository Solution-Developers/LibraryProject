package com.example.LibraryProject.security.service;

import com.example.LibraryProject.entity.user.User;
import com.example.LibraryProject.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user= userRepository.findByEmail(email);
        if (user!=null){
            return new UserDetailsImpl(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getPhone(),
                    user.getEmail(),
                    user.getPassword(),
                    false,
                    user.getUserRole()

            );
        }
        throw new UsernameNotFoundException("User : "+ email+ " not found");
    }
    }

