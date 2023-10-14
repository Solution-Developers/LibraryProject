package com.example.LibraryProject.entity.user;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Column(name = "role_id")
    private Role roleId;


    @Column(name = "user_id")
    private User userId;

}
