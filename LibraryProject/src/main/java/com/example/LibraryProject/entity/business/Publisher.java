package com.example.LibraryProject.entity.business;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)

public class Publisher {

    @Id
    @GeneratedValue
    private long publisherId;

    @NotNull
    private String publisherName;

    @NotNull
    private Boolean builtIn;

}
