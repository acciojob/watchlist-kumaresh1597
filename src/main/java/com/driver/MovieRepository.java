package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
@Repository
public class MovieRepository {

    private Map<String,Movie> movieData = new HashMap<>();
    private Map<String,Director> DirectorsData = new HashMap<>();

    private Map<String, List<String>> directorMovieMap = new HashMap<>();


    public void addMovie(Movie movie) {
        movieData.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        DirectorsData.put(director.getName(), director);
    }

    public void addPair(String movieName, String directorName) {
        if(directorMovieMap.containsKey(directorName)){
            List<String> getPair = directorMovieMap.get(directorName);
            getPair.add(movieName);
            directorMovieMap.put(directorName,getPair);
            return;
        }
        List<String> temp = new ArrayList<>();
        temp.add(movieName);
        directorMovieMap.put(directorName,temp);
    }

    public Optional<Movie> getMovieByName(String movieName) {
        if(movieData.containsKey(movieName)) return Optional.of(movieData.get(movieName));
        return Optional.empty();
    }

    public Optional<Director> getDirectorByName(String name) {
        if(DirectorsData.containsKey(name)) return Optional.of(DirectorsData.get(name));
        return Optional.empty();
    }

    public List<String> getList(String directorName) {
        if(directorMovieMap.containsKey(directorName)){
            return directorMovieMap.get(directorName);
        }
        return new ArrayList<>();
    }

    public List<String> getAllmovies() {
        return new ArrayList<>(movieData.keySet());
    }

    public void deleteDir(String name) {
        directorMovieMap.remove(name);
        DirectorsData.remove(name);
    }

    public void deleteMovies(String m) {
        movieData.remove(m);
    }

    public List<String> getAllDirectors() {
        return new ArrayList<>(DirectorsData.keySet());
    }
}
