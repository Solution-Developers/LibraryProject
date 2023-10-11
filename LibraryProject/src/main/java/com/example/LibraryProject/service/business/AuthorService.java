package com.example.LibraryProject.service.business;

import com.example.LibraryProject.controller.business.AuthorController;
import com.example.LibraryProject.entity.business.Author;
import com.example.LibraryProject.exception.ConflictException;
import com.example.LibraryProject.exception.ResourceNotFoundException;
import com.example.LibraryProject.payload.business.request.AuthorRequest;
import com.example.LibraryProject.payload.business.response.AuthorResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
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
    private final AuthorController authorController;
    private final AuthorRepository authorRepository;
    private final PageableHelper pageableHelper;
    private final AuthorHelper authorHelper;


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

    private AuthorResponse mapAuthorToAuthorResponse(Author author){

        return AuthorResponse.builder()
                .authorName(author.getName())
                .build();
    }

    // * NOT : getAllAuthorsByPageable() ********************

    public Page<AuthorResponse> getAllAuthorsByPage(int page, int size, String sort, String type) {
        Pageable pageableAuthors = pageableHelper.getPageableWithProperties(page,size,sort,type);

        return authorRepository.findAll(pageableAuthors).map(this::mapAuthorToAuthorResponse);
    }


    // * NOT : getAuthorsById() ********************
    public AuthorResponse getAuthorById(Long id) {

        return mapAuthorToAuthorResponse(authorHelper.isAuthorExistById(id));
    }


}
