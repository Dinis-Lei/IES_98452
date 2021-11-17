package ies.moviequotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.moviequotes.model.*;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    
    Quote findById(int id);

    List<Quote> findByMovie(Movie movie);

}
