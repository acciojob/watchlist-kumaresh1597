package com.driver;

import java.util.List;
import java.util.Optional;

public class MovieService {

    MovieRepository movieRepository = new MovieRepository();

    public void addmovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void adddirector(Director director) {
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        movieRepository.addPair(movieName,directorName);
    }

    public Movie getMovieByName(String movieName) {
        Optional<Movie> mve = movieRepository.getMovieByName(movieName);
        if(mve.isPresent()) return mve.get();
        return null;
    }

    public Director getDirectorByName(String name) {
        Optional<Director> dir = movieRepository.getDirectorByName(name);
        if(dir.isPresent()) return dir.get();
        return null;
    }

    public List<String> getMovieListByDirector(String directorName) {
        List<String> mveList = movieRepository.getList(directorName);
        return mveList;
    }

    public List<String> getAllMovies() {
        List<String> mveList = movieRepository.getAllmovies();
        return mveList;
    }

    public void deleteDirector(String name) {
        List<String> moviesToDel = getMovieListByDirector(name);
        for(String m : moviesToDel){
            movieRepository.deleteMovies(m);
        }
        movieRepository.deleteDir(name);
    }

    public void delAll() {
        List<String> dirToDel = movieRepository.getAllDirectors();
        for(String d : dirToDel){
            deleteDirector(d);
        }
    }
}
