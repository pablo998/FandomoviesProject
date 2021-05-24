package com.example.fandomoviesproject.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fandomoviesproject.data.DocuItemCatalog;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;
import com.example.fandomoviesproject.data.SerieItemCatalog;

import java.util.List;

@Dao
public interface DocuCategoryDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProductDocu(DocuItemCatalog product);

    @Update
    void updateDocu(DocuItemCatalog product);

    @Delete
    void deleteDocu(DocuItemCatalog product);

    @Query("SELECT * FROM productsDocumentales")
    List<DocuItemCatalog> loadDocus();

    @Query("SELECT * FROM productsDocumentales WHERE id = :id LIMIT 1")
    DocuItemCatalog loadDocu(int id);

    @Query("SELECT * FROM productsDocumentales WHERE category_id=:categoryId")
    List<DocuItemCatalog> loadDocus(final int categoryId);
}
