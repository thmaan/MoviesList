package com.example.movies;

public class Movie {
    private String title;
    private String releaseDate;
    private String genre;
    private Director director;
    private Actor protagonist;
    private int picture;

    public Movie(String title, String releaseDate, String genre, Director director, Actor protagonist) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.director = director;
        this.protagonist = protagonist;
        this.picture = R.drawable.tenor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public int getPicture() {
        return picture;
    }

    public Actor getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(Actor protagonist) {
        this.protagonist = protagonist;
    }
}
