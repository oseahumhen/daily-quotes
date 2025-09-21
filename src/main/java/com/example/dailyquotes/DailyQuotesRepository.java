package com.example.dailyquotes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyQuotesRepository extends JpaRepository<Quote, Long>{
}
