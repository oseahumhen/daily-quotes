package com.example.dailyquotes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Quote {

    private @Id
    @GeneratedValue Long id;
    private String quote;

    Quote() {}

    Quote(String quote) {
        this.quote = quote;
    }

    Quote(Long id, String quote) {
        this.id = id;
        this.quote = quote;
    }

    public Long getId() {
        return this.id;
    }

    public String getQuote() {
        return this.quote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuote(String name) {
        this.quote = name;
    }
}
