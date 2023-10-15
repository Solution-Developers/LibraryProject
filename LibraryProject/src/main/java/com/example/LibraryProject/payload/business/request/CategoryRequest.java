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
public class CategoryRequest {
    @NotNull(message = "Please enter Category name")
    @Size(min = 1, max = 50, message = "Category name should be at least 2 characters")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+" ,message="Category name must consist of the characters .")
    private String categoryName;
}
