package com.example.LibraryProject.payload.business.response;

import com.example.LibraryProject.entity.business.Book;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PublisherResponse {

    private Long publisherId;

    private String publisherName;

    private List<Book> books;
}
