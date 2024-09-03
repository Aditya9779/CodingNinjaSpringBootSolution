package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieService implements MovieServiceInterface {

    List<Movie> movieList = new ArrayList<>();
    HashMap<String, Movie> movieMap = new HashMap<>();

    @Override
    public List<Movie> getAllMovies() {
        return this.movieList;
    }

    @Override
    public void addMovie(Movie movie) {
        if (movieMap.containsKey(movie.getId())) {
            throw new IdAlreadyExist("Movie ID already exists");
        }
        movieList.add(movie);
        movieMap.put(movie.getId(), movie);
    }

    @Override
    public Movie getMovieById(String id) {
        Movie current = movieMap.get(id);
        if (current == null) {
            throw new IdNotFound("Movie ID not found");
        }
        return current;
    }

    @Override
    public void deleteMovieById(String id) {
        Movie currentMovie = getMovieById(id);
        movieList.remove(currentMovie);
        movieMap.remove(id);
    }

    @Override
    public void updateMovie(String id, Movie movie) {
        if (!movieMap.containsKey(id)) {
            throw new IdNotFound("Movie ID not found");
        }
        Movie currentMovie = getMovieById(id);
        movieList.remove(currentMovie);
        movieList.add(movie);
        movieMap.put(id, movie);
    }
}
