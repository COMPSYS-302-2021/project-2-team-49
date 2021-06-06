package com.example.design1;

import java.io.Serializable;

public class Books implements Serializable {
    String name;
    String author;
    int viewed;
    char genre;
    String id;
    int pic;
    String blurb;
    int cost;

    public Books(String name, String author, int viewed, char genre, String id, int pic, String blurb, int cost) {
        this.name = name;
        this.author = author;
        this.viewed = viewed;
        this.genre = genre;
        this.pic = pic;
        this.id = id;
    }

    public String getTitle() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getCoverImage() {
        return pic;
    }
}
