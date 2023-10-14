package com.example.LibraryProject.entity.business;



import jdk.jshell.Snippet;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Author {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @NotNull
    private Boolean builtIn;

    @OneToMany(mappedBy = "authorId", cascade = CascadeType.ALL)
    private Book books;

}
