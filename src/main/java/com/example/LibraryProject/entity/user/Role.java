package com.example.LibraryProject.entity.user;


import com.example.LibraryProject.entity.enums.RoleType;
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

    @Enumerated
    private RoleType roleName;

    private String name;

    @OneToMany(mappedBy = "roleId")
    private List<UserRole> userRoles;


}
