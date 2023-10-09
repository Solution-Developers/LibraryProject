package com.example.LibraryProject.entity.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.DateTimeException;
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
    private long id;

    @NotNull
    private long userId;

    @NotNull
    private long bookId;

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





}
