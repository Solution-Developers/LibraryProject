package com.example.LibraryProject.entity.business;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean builtIn;

    private int sequence;

    @OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL)
    private List<Book> books;


}
