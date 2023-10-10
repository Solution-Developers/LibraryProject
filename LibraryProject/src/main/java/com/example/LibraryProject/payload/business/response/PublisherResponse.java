package com.example.LibraryProject.payload.business.response;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PublisherResponse {

    private Long publisherId;

    private String publisherName;
}
