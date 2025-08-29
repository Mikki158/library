package com.example.library.controller;

import com.example.library.dto.ReadingDto;
import com.example.library.service.ReadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/readings")
@RequiredArgsConstructor
public class ReadingRestController {

    private final ReadingService readingService;

    @GetMapping
    public List<ReadingDto> getAllReadings() {
        return readingService.findAll()
                .stream()
                .map(reading -> new ReadingDto(
                        reading.getClient().getFullName(),
                        reading.getClient().getBirthDate().toString(),
                        reading.getBook().getTitle(),
                        reading.getBook().getAuthor(),
                        reading.getBook().getIsbn(),
                        reading.getDateTaken().toString()
                ))
                .collect(Collectors.toList());
    }
}
