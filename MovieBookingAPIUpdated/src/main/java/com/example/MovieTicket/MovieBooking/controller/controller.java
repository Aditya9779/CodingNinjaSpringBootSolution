package com.example.MovieTicket.MovieBooking.controller;

import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class controller {

    @Autowired
    MovieServiceInterface movieServiceInterface;

    @PostMapping("/movie")
    public void addMovies(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException("ID not found");
        }
        movieServiceInterface.addMovie(movie);

    }

    @GetMapping("/movies")
    public List<Movie> getAllMovie(String id) {
        return movieServiceInterface.getAllMovies();
    }

    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable String id) {
        return movieServiceInterface.getMovieById(id);
    }

    @DeleteMapping("/movie/{id}")
    public void removeMovieByid(@PathVariable String id) {
        movieServiceInterface.deleteMovie(id);
    }

    @PutMapping("/update/{id}")
    public void updateMovie(@RequestBody Movie topic, @PathVariable String id) {
        movieServiceInterface.updateMovie(id, topic);
    }
}
