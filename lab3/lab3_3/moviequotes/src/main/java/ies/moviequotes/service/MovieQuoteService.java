package ies.moviequotes.service;

import ies.moviequotes.model.*;
import ies.moviequotes.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieQuoteService {
    
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private QuoteRepository quoteRepository;

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> saveMovies(List<Movie> movie) {
        return movieRepository.saveAll(movie);
    }

    public Quote saveQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    public List<Quote> saveQuotes(List<Quote> quote) {
        return quoteRepository.saveAll(quote);
    }

    public Quote findQuoteById(int id){
        return quoteRepository.findById(id);
    }

    public List<Quote> findQuotesByMovie(Movie movie){
        return quoteRepository.findByMovie(movie);
    }

    public int countQuotes(){
        return (int) quoteRepository.count();
    }

    public Movie findMovieById(int id){
        return movieRepository.findById(id);
    }

    public List<Quote> findAllQuotes(){
        return quoteRepository.findAll();
    }

    public List<Movie> findAllMovies(){
        return movieRepository.findAll();
    }
}
