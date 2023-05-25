package com.driver;

public class Movie {

    private String name;
    private int dur;
    private double imdb_rating;

    public Movie() {
    }

    public Movie(String name, int dur, double imdb_rating) {
        this.name = name;
        this.dur = dur;
        this.imdb_rating = imdb_rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDur() {
        return dur;
    }

    public void setDur(int dur) {
        this.dur = dur;
    }

    public double getImdb_rating() {
        return imdb_rating;
    }

    public void setImdb_rating(double imdb_rating) {
        this.imdb_rating = imdb_rating;
    }
}
