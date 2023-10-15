package com.example.LibraryProject.service.validator;

import com.example.LibraryProject.entity.user.User;
import com.example.LibraryProject.exception.ConflictException;
import com.example.LibraryProject.payload.message.ErrorMessages;
import com.example.LibraryProject.payload.user.UserRequest;
import com.example.LibraryProject.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniquePropertyValidator {

    private final UserRepository userRepository;

    public void checkUniqueProperties(User user, UserRequest userRequest){

        String updatedPhoneNumber = "";
        String updatedEmail = "";
        boolean isChanged = false;

        if(!(user.getPhone().equalsIgnoreCase(userRequest.getPhone()))){
            updatedPhoneNumber = userRequest.getPhone();
            isChanged = true;
        }
        if(!(user.getEmail().equalsIgnoreCase(userRequest.getEmail()))){
            updatedEmail = userRequest.getEmail();
            isChanged = true;
        }

        if(isChanged){
            checkDuplicate(updatedPhoneNumber,updatedEmail);
        }

    }



    public void checkDuplicate(String phone, String email){

        if(userRepository.existsByPhoneNumber(phone)){
            throw new ConflictException(String.format(ErrorMessages.ALREADY_REGISTER_WITH_PHONE, phone));
        }
        if(userRepository.existsByEmail(email)){
            throw new ConflictException(String.format(ErrorMessages.ALREADY_REGISTER_WITH_EMAIL, email));
        }


    }





}
