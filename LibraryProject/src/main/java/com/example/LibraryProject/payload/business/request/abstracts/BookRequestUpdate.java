package com.example.LibraryProject.payload.business.request.abstracts;


import lombok.*;


import javax.validation.constraints.NotNull;
import java.io.File;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public abstract class BookRequestUpdate {


    @NotNull(message = "Please must be write book name")
    private String name;

    @NotNull(message = "Please must be write book name")
    private String isbn;

    private int pageCount;

    @NotNull(message = "Please must be write book name")
    private Long authorId;

    @NotNull(message = "Please must be write book name")
    private Long publisherId;

    private int publishDate;

    @NotNull(message = "Please must be write book name")
    private Long categoryId;

    private File image;

    @NotNull(message = "Please must be write book name")
    private String shelfCode;

    @NotNull(message = "Please must be write book name")
    private boolean featured;

    private boolean loanable;

}
