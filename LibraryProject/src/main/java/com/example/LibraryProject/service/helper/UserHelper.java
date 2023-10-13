package com.example.LibraryProject.service.helper;

import com.example.LibraryProject.entity.user.User;
import com.example.LibraryProject.payload.message.ErrorMessages;
import com.example.LibraryProject.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.module.ResolutionException;

@Component
@RequiredArgsConstructor
public class UserHelper {
    private final UserRepository userRepository;

    public User isUserExistById(Long id){
    return     userRepository.findById(id).orElseThrow(()->
                new ResolutionException(String.format(ErrorMessages.NOT_FOUND_USER)));
    }

    public User isUserExistByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
