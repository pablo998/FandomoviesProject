package com.example.fandomoviesproject.data;

import java.util.ArrayList;
import java.util.List;

public class CategoryDocuItemCatalog {

    public final List<DocuItemCatalog> items;
    public final int id;
    public final String content;

    public CategoryDocuItemCatalog(int id, String content){
        items = new ArrayList<>();
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
