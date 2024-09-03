package org.assisment.assisgnment.repository;

import org.assisment.assisgnment.domain.Genre;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepo {

    Map<String,List<String>> genreMap = new HashMap<>();
    public Map<String,List<String>> getMoviesList(Genre genre){
        genreMap.put("horror", new ArrayList<>(List.of("Annabelle", "Conjuring","Conjuring 2")));
        genreMap.put("comedy", new ArrayList<>(List.of("Golmal","Fir hera pheri","Welcome")));
        genreMap.put("romantic", new ArrayList<>(List.of("Student of the year","Chennai Express","365 Days")));
        genreMap.put("drama", new ArrayList<>(List.of("zindagi na milegi","Jersy","Hero")));
        genreMap.put("thriller", new ArrayList<>(List.of("Farzi","jersy","Money Hiest")));
        genreMap.put("suspense", new ArrayList<>(List.of("Stranger Things","Breaking Bad")));
        genreMap.put("sci-fi", new ArrayList<>(List.of("Space","jersy")));
        return genreMap;
    }
}
