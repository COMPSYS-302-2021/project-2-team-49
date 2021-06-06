package com.example.design1;

import java.io.Serializable;

public class Books implements Serializable {
    String name;
    String author;
    int viewed;
    char genre;
    String id;
    int cost;
    String blurb;
    int[] pic;

    public Books(String name, String author, int viewed, char genre, String id, int cost, String blurb, int[] pic) {
        this.name = name;
        this.author = author;
        this.viewed = viewed;
        this.genre = genre;
        this.pic = pic;
        this.id = id;
        this.cost = cost;
        this.blurb = blurb;
    }

    public String getTitle() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getBlurb() {return blurb;}

    public int getCost() {return cost;}

    public int getViewed() {return viewed;}

    public char getGenre() {return genre;}

    public String getBookID() {return id;}

    public int[] getCoverImages() {
        return pic;
    }
}
