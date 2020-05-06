package com.example.movies;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Movie> movies;
    public static ArrayList<Actor> actors;
    public static ArrayList<Director> directors;
    @Override
    public void onCreate() {
        super.onCreate();

        movies = new ArrayList<Movie>();
        actors = new ArrayList<Actor>();
        directors = new ArrayList<Director>();

        Actor wm = new Actor("Wagner Moura","1970");
        actors.add(wm);
        Actor ww = new Actor("Wagner","1970");
        actors.add(ww);
        Director jp = new Director("José Padilha","1967");
        directors.add(jp);
        movies.add(new Movie("Tropa de Elite","2012","Ação",jp,wm));

    }
}
