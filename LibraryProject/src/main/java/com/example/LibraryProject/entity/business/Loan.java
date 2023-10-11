
package com.example.LibraryProject.entity.business;


import com.example.LibraryProject.entity.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.;
import org.springframework.lang.Nullable;

import javax.persistence.;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Loan {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Long userId;

    @NotNull
    private Long bookId;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,'T' HH:mm:ss",timezone = "UTC")
    private LocalDateTime loanDate;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,'T' HH:mm:ss",timezone = "UTC")
    private LocalDateTime expireDate;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,'T' HH:mm:ss",timezone = "UTC")
    private LocalDateTime returnDate;

    @Nullable
    //todo : notes for employee or admin
    private String notes;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Book book;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;






}