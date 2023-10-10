package com.example.LibraryProject.entity.business;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)

public class Publisher {

    @Id
    @GeneratedValue
    private Long publisherId;

    @NotNull
    private String publisherName;

    @NotNull
    private Boolean builtIn;

    @OneToMany(mappedBy = "publisherId", cascade = CascadeType.ALL)
    private List<Book> books;

}
