package org.assisment.assisgnment.controller;

import org.assisment.assisgnment.domain.Genre;
import org.assisment.assisgnment.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class movie {
    @Autowired
    MovieRepo movieRepo;

    @RequestMapping("/movies")
    public ModelAndView getMovies(Genre genre) {
        Map<String, List<String>> genreMap1 = movieRepo.getMoviesList(genre);
        List<String> stringList = genreMap1.get(genre.getGenre());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moviesList");
        modelAndView.addObject("movieslist", stringList);
        return modelAndView;
    }
}
