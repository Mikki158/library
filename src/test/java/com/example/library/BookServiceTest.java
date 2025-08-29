package com.example.library;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Book book1 = new Book(1L, "Book One", "Author One", 11111L);
        Book book2 = new Book(2L, "Book Two", "Author Two", 22222L);
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        List<Book> books = bookService.findAll();

        assertEquals(2, books.size());
        assertEquals("Book One", books.get(0).getTitle());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void testSave() {
        Book book = new Book(null, "New Book", "Author", 33333L);

        bookService.save(book);

        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testFindById() {
        Book book = new Book(1L, "Book One", "Author One", 11111L);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookService.findById(1L);

        assertNotNull(result);
        assertEquals("Book One", result.getTitle());
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void testEditBook() {
        Book existingBook = new Book(1L, "Old Title", "Author", 11111L);
        Book updatedDetails = new Book(null, "New Title", "Author Updated", 11111L);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(existingBook));

        bookService.editBook(1L, updatedDetails);

        assertEquals("New Title", existingBook.getTitle());
        assertEquals("Author Updated", existingBook.getAuthor());
        verify(bookRepository, times(1)).save(existingBook);
    }
}
