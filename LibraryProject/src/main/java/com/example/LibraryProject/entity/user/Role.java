package com.example.LibraryProject.entity.user;


import com.example.LibraryProject.entity.enums.RoleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "KTP")
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType roleName;

    private String name;



    @ManyToMany
    @JoinTable(name = "user_role",
               joinColumns = @JoinColumn(name = "role_id"),
               inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users ;


}
