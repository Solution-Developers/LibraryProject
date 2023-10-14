package com.example.LibraryProject.payload.business.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LoanRequest {

    @NotNull(message = "loanDate must not be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,'T' HH:mm:ss",timezone = "UTC")
    private LocalDateTime loanDate;

    @NotNull(message ="expireDate must not be empty" )
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,'T' HH:mm:ss",timezone = "UTC")
    private LocalDateTime expireDate;

    @NotNull(message = "returnDate must not be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,'T' HH:mm:ss",timezone = "UTC")
    private LocalDateTime returnDate;

    @Nullable()
    //todo : notes for employee or admin
    private String notes;


}
