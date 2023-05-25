package com.driver;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class Director {

    private String name;
    private int noOfMovies;
    private double imdb_rating;

    public Director() {
    }

    public Director(String name, int noOfMovies, double imdb_rating) {
        this.name = name;
        this.noOfMovies = noOfMovies;
        this.imdb_rating = imdb_rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfMovies() {
        return noOfMovies;
    }

    public void setNoOfMovies(int noOfMovies) {
        this.noOfMovies = noOfMovies;
    }

    public double getImdb_rating() {
        return imdb_rating;
    }

    public void setImdb_rating(double imdb_rating) {
        this.imdb_rating = imdb_rating;
    }
}
