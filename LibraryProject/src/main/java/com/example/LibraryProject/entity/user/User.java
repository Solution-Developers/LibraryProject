package com.example.LibraryProject.entity.user;


import com.example.LibraryProject.entity.business.Loan;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_user")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //!auto? identity yapıyorduk normalde?
    private Long id;

   @NotNull(message = "First name must not be empty")
   @Size(min=2, max=30)
   private String firstName;

   @NotNull(message = "Last name must not be empty")
   @Size(min=2, max=30)
   private String lastName;

   @NotNull(message = "Score must be between -2 and 2")
   @Min(-2)
   @Max(+2) //
   private Integer score;

   @NotNull(message = "Address must not be empty")
   @Size(min = 10, max = 100)
   private String address;

   @NotNull
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddd-ddd-dddd") //todo format phone number kısmı
   @Column(unique = true)
   private String phone;

   @Column(nullable = true)
   @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
   private LocalDate birthDate;

   @NotNull(message = "Email must not be empty")
   @Size(min=10, max=80)
   @Email
   @Column(unique = true)
   private String email;

   @NotNull(message = "Password must not be empty")
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   private String password;

   @NotNull
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddTHH:mm:ssZ") //! saniyede sıkıntı olabilir SS?
   private LocalDateTime createDate;


   @Column(nullable = true)
   //todo Hash ne yapıcaz???
   private String resetPasswordCode;

    @NotNull
    //todo default false nasıl yapıcaz??
    private Boolean builtIn;

    @OneToMany(mappedBy = "user")
    private List<Loan> loanList;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Role> roles;


}
