package com.example.library.controller;

import com.example.library.entity.Reading;
import com.example.library.service.BookService;
import com.example.library.service.ClientService;
import com.example.library.service.ReadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/readings")
@RequiredArgsConstructor
public class ReadingController {

    private final ReadingService readingService;
    private final BookService bookService;
    private final ClientService clientService;

    @GetMapping
    public String listReading(Model model) {
        List<Reading> readings = readingService.findAll();
        model.addAttribute("readings", readings);
        return "readings/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("reading", new Reading());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("books", bookService.findAll());
        return "readings/add";
    }

    @PostMapping("/add")
    public String saveReading(@ModelAttribute("reading") Reading reading) {
        readingService.save(reading);
        return "redirect:/readings";
    }

    @GetMapping("/delete/{id}")
    public String deleteReading(@PathVariable Long id) {
        readingService.delete(id);
        return "redirect:/readings";
    }
}
