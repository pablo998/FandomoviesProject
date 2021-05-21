package com.example.fandomoviesproject.data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "categoriesDocumentales")
public class CategoryDocuItemCatalog {

    @PrimaryKey
    public int id;

    public String content;

    @Ignore
    @SerializedName("productsDocumentales")
    public List<DocuItemCatalog> items;

    @Override
    public String toString() {
        return content;
    }
}
