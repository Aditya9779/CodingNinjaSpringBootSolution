package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Model.Movie;

import java.util.List;

public interface MovieServiceInterface {
    public List<Movie> getAllMovies();

    public void addMovie(Movie movie);

    public Movie getMovieById(String id);

    void deleteMovieById(String id);

    void updateMovie(String id, Movie movie);
}
