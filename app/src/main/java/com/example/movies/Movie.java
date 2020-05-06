package com.example.movies;

public class Movie {
    private String title;
    private String releaseDate;
    private String genre;
    private Director director;
    private Actor protagonist;
    private int picture;

    Movie(String title, String releaseDate, String genre, Director director, Actor protagonist) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.director = director;
        this.protagonist = protagonist;
        this.picture = R.drawable.tenor;
    }
    String getTitle() {
        return title;
    }
    String getReleaseDate() {
        return releaseDate;
    }
    String getGenre() {
        return genre;
    }
    Actor getProtagonist() {
        return protagonist;
    }
    public Director getDirector() {
        return director;
    }
    int getPicture() {
        return picture;
    }

}
