package com.example.LibraryProject.payload.business.request;


import lombok.*;


import javax.validation.constraints.NotNull;
import java.io.File;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BookRequest {


    @NotNull(message = "Please must be write book name")
    private String name;

    @NotNull(message = "Please must be write book name")
    private String isbn;

    private int pageCount;

    @NotNull(message = "Please must be write book name")
    private Long authorId;

    private Long publisherId;

    private int publishDate;

    private Long categoryId;

    private File image;

    private String shelfCode;

    private boolean featured;

}
