package com.example.library.service;

import com.example.library.entity.Reading;

import java.util.List;

public interface ReadingService {

    List<Reading> findAll();

    void save(Reading reading);

    void delete(Long id);
}
