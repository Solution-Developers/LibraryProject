package com.example.LibraryProject.payload.business.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PublisherRequest {
    @NotNull(message = "Publisher name must not be empty")
    private String publisherName;
}
