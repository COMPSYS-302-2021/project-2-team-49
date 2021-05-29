package com.example.design1;

public class Books {
    String name;
    String author;
    int viewed;
    char genre;
    String id;
    int pic;

    public Books(String name, String author, int viewed, char genre, String id, int pic) {
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
