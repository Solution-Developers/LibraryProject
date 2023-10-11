package com.example.LibraryProject.payload.business.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AuthorRequest {

    @NotNull(message = "Please enter Author name")
    @Size(min = 1, max = 50, message = "Author name should be at least 2 characters")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+" ,message="Author name must consist of the characters .")
    private String authorName;
}
