package com.example.dailyquotes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dailyquotes")
public class DailyQuotesController {

    private final DailyQuotesRepository repository;

    DailyQuotesController(DailyQuotesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/welcome")
    ResponseEntity<String> welcome () {
        return ResponseEntity.ok("Welcome to daily quotes!");
    }

    @GetMapping
    ResponseEntity<List<Quote>> getQuotes () {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{requestedId}")
    ResponseEntity<Optional<Quote>> getQuotes (@PathVariable Long requestedId) {
        Optional<Quote> quote = repository.findById(requestedId);
        if (quote.isPresent()) {
            return ResponseEntity.ok(repository.findById(requestedId));
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    ResponseEntity<Quote> newQuote(@RequestBody Quote newQuote) {
        Quote saved = repository.save(newQuote);
        return ResponseEntity
                .status(201)
                .body(saved);
    }
}

