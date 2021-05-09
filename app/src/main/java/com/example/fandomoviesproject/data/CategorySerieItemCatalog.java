package com.example.fandomoviesproject.data;

import java.util.ArrayList;
import java.util.List;

public class CategorySerieItemCatalog {

    public final List<SerieItemCatalog> items;
    public final int id;
    public final String content;

    public CategorySerieItemCatalog(int id, String content){
        items = new ArrayList<>();
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString(){
        return super.toString();
    }


}
