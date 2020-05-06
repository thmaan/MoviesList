package com.example.movies;

import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Movie {
    private String title;
    private String releaseDate;
    private String genre;
    private Director director;
    private Actor protagonist;

    public Movie(String title, String releaseDate, String genre, Director director, Actor protagonist) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.director = director;
        this.protagonist = protagonist;
    }

    public Movie(TextView title, TextView year, TextView genre) {
        this.title = title.toString();
        this.releaseDate = year.toString();
        this.genre = genre.toString();
    }

    public Movie(String title, String year, String genre) {
        this.title = title;
        this.releaseDate = year;
        this.genre = genre;
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

    public Actor getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(Actor protagonist) {
        this.protagonist = protagonist;
    }
}
