package com.example.LibraryProject.payload.business.request.abstracts;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BookRequestSave extends BookRequestUpdate{//TODO : Bu islemi default'da false yaparak da yapabilirim ileriki gunlerde duzeltme yapabilirsin. Zaman az diye logic yazilmadi

    private boolean active;
}
