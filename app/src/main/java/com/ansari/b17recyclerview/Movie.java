package com.ansari.b17recyclerview;

public class Movie {

    String title,genere,year;

    public Movie(String title, String genere, String year) {
        this.title = title;
        this.genere = genere;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
