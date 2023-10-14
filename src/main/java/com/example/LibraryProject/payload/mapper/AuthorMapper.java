package com.example.LibraryProject.payload.mapper;


import com.example.LibraryProject.entity.business.Author;
import com.example.LibraryProject.payload.business.request.AuthorRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {


    public Author mapAuthorRequestToAuthor(AuthorRequest authorRequest){
        return Author.builder()
                .name(authorRequest.getAuthorName())
                .build();

    }

    public Author mapAuthorToUpdateRequest(AuthorRequest authorRequest, Long id){
        return mapAuthorRequestToAuthor(authorRequest)
                .toBuilder()
                .id(id)
                .build();

    }

}
