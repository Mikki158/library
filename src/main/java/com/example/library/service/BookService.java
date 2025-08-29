package com.example.library.service;

import com.example.library.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    void save(Book book);

    Book findById(Long id);

    void editBook(Long id, Book bookDetails);
}
