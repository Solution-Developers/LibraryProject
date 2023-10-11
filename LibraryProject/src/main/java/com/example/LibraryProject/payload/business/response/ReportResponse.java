package com.example.LibraryProject.payload.business.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ReportResponse<M> {

    private int book;
    private int authors;
    private int publishers;
    private int categories;
    private int loans;
    private int unReturnedBooks;
    private int expiredBooks;
    private int members;

}

