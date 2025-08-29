package com.example.library.service.imp;

import com.example.library.entity.Reading;
import com.example.library.repository.ReadingRepository;
import com.example.library.service.ReadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadingServiceImpl implements ReadingService {

    private final ReadingRepository readingRepository;

    @Override
    public List<Reading> findAll() {
        return readingRepository.findAll();
    }

    @Override
    public void save(Reading reading) {
        readingRepository.save(reading);
    }

    @Override
    public void delete(Long id) {
        Reading reading = findById(id);
        readingRepository.delete(reading);
    }

    Reading findById(Long id) {
        return readingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Читаемой книги с id: " + id + " не найдено"));
    }
}
