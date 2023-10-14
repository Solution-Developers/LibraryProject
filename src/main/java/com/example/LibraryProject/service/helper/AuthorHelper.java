package com.example.LibraryProject.service.helper;

import com.example.LibraryProject.entity.business.Author;
import com.example.LibraryProject.exception.ConflictException;
import com.example.LibraryProject.exception.ResourceNotFoundException;
import com.example.LibraryProject.payload.business.request.AuthorRequest;
import com.example.LibraryProject.payload.message.ErrorMessages;
import com.example.LibraryProject.repository.business.AuthorRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorHelper {

    private final AuthorRepository authorRepository;


    public Author isAuthorExistById(Long id){

        return authorRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessages.NOT_FOUND_AUTHOR,id)));
    }

    public Author mapAuthorRequestToAuthor(AuthorRequest authorRequest){
        return Author.builder()
                .name(authorRequest.getAuthorName())
                .build();

    }

    public boolean isAuthorExistByAuthorName(String authorName){
        boolean existAuthor = authorRepository.existsAuthorByAuthorNameEqualsIgnoreCase(authorName);

        if (existAuthor){

            throw new ConflictException(String.format(ErrorMessages.ALREADY_EXIST_AUTHOR, authorName));

        }else {

            return false;

        }
    }
}
