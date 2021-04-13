package com.example.fandomoviesproject.MoviesList;

public class catalogItem {

    public final int id;
    public final String content;

    public catalogItem( int id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
