package com.example.movies;

import androidx.annotation.NonNull;

public class Director {
    private String name;
    private String birthDate;
    private int picture;

    Director(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        picture = R.drawable.tenor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     String getBirthDate() {
        return birthDate;
    }

     int getPicture() {
        return picture;
    }
    @NonNull
    @Override
    public String toString(){
        return name;
    }
}
