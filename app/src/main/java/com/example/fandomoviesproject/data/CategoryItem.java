package com.example.fandomoviesproject.data;

import java.util.ArrayList;
import java.util.List;

public class CategoryItem  {

    public final List<PeliculaItem> items;
    public final int id;
    public final String content;

    public CategoryItem(int id, String content){
        items = new ArrayList<>();
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString(){
        return super.toString();
    }


}
