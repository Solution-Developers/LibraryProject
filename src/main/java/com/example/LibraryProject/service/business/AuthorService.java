package com.example.LibraryProject.service.business;

import com.example.LibraryProject.controller.business.AuthorController;
import com.example.LibraryProject.entity.business.Author;
import com.example.LibraryProject.exception.ConflictException;
import com.example.LibraryProject.exception.ResourceNotFoundException;
import com.example.LibraryProject.payload.business.request.AuthorRequest;
import com.example.LibraryProject.payload.business.response.AuthorResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.payload.mapper.AuthorMapper;
import com.example.LibraryProject.payload.message.ErrorMessages;
import com.example.LibraryProject.payload.message.SuccessMessages;
import com.example.LibraryProject.repository.business.AuthorRepository;
import com.example.LibraryProject.service.helper.AuthorHelper;
import com.example.LibraryProject.service.helper.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final PageableHelper pageableHelper;
    private final AuthorHelper authorHelper;
    private final AuthorMapper authorMapper;


    // * NOT : saveAuthors() ********************
    public ResponseMessage<AuthorResponse> saveAuthor(AuthorRequest authorRequest) {
        authorHelper.isAuthorExistByAuthorName(authorRequest.getAuthorName());

        Author savedAuthor = authorRepository.save(authorHelper.mapAuthorRequestToAuthor(authorRequest));

        return ResponseMessage.<AuthorResponse>builder()
                .httpStatus(HttpStatus.OK)
                .message(SuccessMessages.AUTHOR_SAVED)
                .object(mapAuthorToAuthorResponse(savedAuthor))
                .build();

    }

    public AuthorResponse mapAuthorToAuthorResponse(Author author){ // TODO: Pageable yapının islemleri kontrol edilecek

        return AuthorResponse.builder()
                .authorName(author.getName())
                .build();
    }



    // * NOT : getAllAuthorsByPageable() ********************

    public Page<AuthorResponse> getAllAuthorsByPage(int page, int size, String sort, String type) {
        Pageable pageableAuthors = pageableHelper.getPageableWithProperties(page,size,sort,type);

        return authorRepository.findAll(pageableAuthors).map(this::mapAuthorToAuthorResponse); // TODO : Bu satir kontrol edilecek
    }


    // * NOT : getAuthorsById() ********************
    public ResponseMessage<AuthorResponse> getAuthorById(Long id) {

        return ResponseMessage.<AuthorResponse>builder()
                .httpStatus(HttpStatus.OK)
                .object(mapAuthorToAuthorResponse(authorHelper.isAuthorExistById(id)))
                .build();
    }


    // * NOT : deleteAuthorsById() ********************
    public ResponseMessage deleteAuthorById(Long id) {
        authorHelper.isAuthorExistById(id);
        authorRepository.deleteById(id);

        return ResponseMessage.builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format(SuccessMessages.AUTHOR_DELETED,id))
                .build();

    }


    // * NOT : updateAuthorsById() ********************

    public ResponseMessage<AuthorResponse> updateAuthorById(AuthorRequest authorRequest, Long authorId) {
        Author author =authorHelper.isAuthorExistById(authorId);

        if(!author.getName().equalsIgnoreCase(authorRequest.getAuthorName())){
            authorHelper.isAuthorExistByAuthorName(authorRequest.getAuthorName());
        }

        Author authorUpdate = authorMapper.mapAuthorToUpdateRequest(authorRequest,authorId);
        Author savedAuthor = authorRepository.save(authorUpdate);

        return ResponseMessage.<AuthorResponse>builder()
                .message(SuccessMessages.AUTHOR_UPDATED)
                .httpStatus(HttpStatus.OK)
                .object(mapAuthorToAuthorResponse(savedAuthor))
                .build();
    }
}