package com.example.fandomoviesproject.data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "categoriesSeries")
public class CategorySerieItemCatalog {

    @PrimaryKey
    public int id;

    public String content;

    @Ignore
    @SerializedName("productsSeries")
    public List<SerieItemCatalog> items;

    @Override
    public String toString() {
        return content;
    }
}
