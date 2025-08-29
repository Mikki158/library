package com.example.library;

import com.example.library.entity.Book;
import com.example.library.entity.Client;
import com.example.library.entity.Reading;
import com.example.library.repository.ReadingRepository;
import com.example.library.service.imp.ReadingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class ReadingServiceTest {

    @Mock
    private ReadingRepository readingRepository;

    @InjectMocks
    private ReadingServiceImpl readingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Client client = new Client(1L, "John Doe", LocalDate.of(1990, 1, 1));
        Book book = new Book(1L, "Book One", "Author One", 11111L);
        Reading reading1 = new Reading(1L, client, book, LocalDate.of(2025, 8, 29));
        Reading reading2 = new Reading(2L, client, book, LocalDate.of(2025, 8, 30));
        when(readingRepository.findAll()).thenReturn(Arrays.asList(reading1, reading2));

        List<Reading> readings = readingService.findAll();

        assertEquals(2, readings.size());
        assertEquals("Book One", readings.get(0).getBook().getTitle());
        verify(readingRepository, times(1)).findAll();
    }

    @Test
    void testSave() {
        Client client = new Client(1L, "John Doe", LocalDate.of(1990, 1, 1));
        Book book = new Book(1L, "New Book", "Author", 22222L);
        Reading reading = new Reading(null, client, book, LocalDate.of(2025, 8, 29));

        readingService.save(reading);

        verify(readingRepository, times(1)).save(reading);
    }

    @Test
    void testDelete() {
        Long readingId = 1L;

        readingService.delete(readingId);

        verify(readingRepository, times(1)).deleteById(readingId);
    }
}
