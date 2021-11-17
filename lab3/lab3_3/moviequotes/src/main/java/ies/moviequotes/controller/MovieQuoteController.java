package ies.moviequotes.controller;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ies.moviequotes.model.Movie;
import ies.moviequotes.model.Quote;
import ies.moviequotes.service.MovieQuoteService;

@RestController
public class MovieQuoteController {
    
    @Autowired
    private MovieQuoteService service;

    private Random random = new Random();

    @GetMapping("/api/quote")
    public Quote quote(@RequestParam(value = "show", required =  false ) Integer show_id){

        int id; 
        Quote quote;
        
        if( show_id == null){
            id = random.nextInt(service.countQuotes());
            quote = service.findQuoteById(id);
        }
        else{
            Movie movie = service.findMovieById(show_id);
            List<Quote> quotes = service.findQuotesByMovie(movie);
            id = random.nextInt(quotes.size());
            quote = quotes.get(id);
        }
        
        return quote;
    }

    @PostMapping("/api/addmovie")
    public Movie createMovie(@Valid @RequestBody Movie movie){
        return service.saveMovie(movie);
    }

    @PostMapping("/api/addquotes")
    public List<Quote> createQuotes(@Valid @RequestBody List<Quote> quotes){
        return service.saveQuotes(quotes);
    }


    @GetMapping("api/shows")
    public List<Movie> shows(){
        return service.findAllMovies();
    }

}
