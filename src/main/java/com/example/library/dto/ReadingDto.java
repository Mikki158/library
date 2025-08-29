package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReadingDto {

    private String fullName;
    private String birthDate;
    private String title;
    private String author;
    private Long isbn;
    private String dateTaken;
}
