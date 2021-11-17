package ies.moviequotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.moviequotes.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    
    Movie findById(int id);
}
