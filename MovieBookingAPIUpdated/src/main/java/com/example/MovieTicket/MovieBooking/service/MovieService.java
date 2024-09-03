package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.communicator.RatingRestCommunicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService implements MovieServiceInterface {

    List<Movie> movieList = new ArrayList<>();
    HashMap<String, Movie> movieMap = new HashMap<>();
    @Autowired
    private RatingRestCommunicator ratingServiceCommunicator;

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
        Map<String, Long> map = new HashMap<>();
        map.put(movie.getId(), movie.getMovieRating());
        ratingServiceCommunicator.addRating(map);
    }

    @Override
    public Movie getMovieById(String id) {
        Movie current = movieMap.get(id);
        if (current == null) {
            throw new IdNotFound("Movie ID not found");
        }
        ratingServiceCommunicator.getRating(id);
        return current;
    }

    @Override
    public void deleteMovie(String id) {
        Movie currentMovie = getMovieById(id);
        movieList.remove(currentMovie);
        movieMap.remove(id);
        ratingServiceCommunicator.deleteRating(id);
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
        Map<String, Long> map = new HashMap<>();
        map.put(movie.getId(), movie.getMovieRating());
        ratingServiceCommunicator.updateRating(map);
    }
}
