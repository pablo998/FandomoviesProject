package com.example.fandomoviesproject.data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "categoriesPelis")
public class CategoryItemCatalog {

    @PrimaryKey
    public int id;

    public String content;

    @Ignore
    @SerializedName("productsPelis")
    public List<PeliculaItemCatalog> items;

    @Override
    public String toString() {
        return content;
    }
}
