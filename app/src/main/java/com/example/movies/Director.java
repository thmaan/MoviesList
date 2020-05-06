package com.example.movies;

public class Director {
    private String name;
    private String birthDate;
    private int picture;

    public Director(String name, String birthDate) {
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

    public String getBirthDate() {
        return birthDate;
    }

    public int getPicture() {
        return picture;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    @Override
    public String toString(){
        return name;
    }
}
