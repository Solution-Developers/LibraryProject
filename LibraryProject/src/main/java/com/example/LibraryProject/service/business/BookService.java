package com.example.LibraryProject.service.business;

import com.example.LibraryProject.entity.business.Book;
import com.example.LibraryProject.payload.business.request.abstracts.BookRequestSave;
import com.example.LibraryProject.payload.business.response.BookResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.payload.mapper.BookMapper;
import com.example.LibraryProject.payload.message.SuccessMessages;
import com.example.LibraryProject.repository.business.BookRepository;
import com.example.LibraryProject.service.helper.BookHelper;
import com.example.LibraryProject.service.helper.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookHelper bookHelper;
    private final BookMapper bookMapper;
    private final PageableHelper pageableHelper;

    public ResponseMessage<BookResponse> saveBook(BookRequestSave bookRequest) {

        // TODO : burada kaldim



        return null;
    }

    public BookResponse getBookById(Long bookId) {
        Book bookExist = bookHelper.isBookExistById(bookId);


        return bookMapper.mapBookToBookResponse(bookExist);
    }

    public ResponseMessage deleteBookById(Long bookId) {
        bookHelper.isBookExistById(bookId);
        bookRepository.deleteById(bookId);

        return ResponseMessage.builder()
                .httpStatus(HttpStatus.OK)
                .message(SuccessMessages.BOOK_DELETED)
                .build();
    }

    public Page<BookResponse> getAllBooksByPage(Long id, int page, int size, String sort, String type) {

        Pageable pageable = pageableHelper.getPageableWithProperties(page,size,sort,type);

        return bookRepository.findByBookById(id,pageable).map(bookMapper::mapBookToBookResponse);
    }

}