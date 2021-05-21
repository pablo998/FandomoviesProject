package com.example.fandomoviesproject.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fandomoviesproject.data.PeliculaItemCatalog;
import com.example.fandomoviesproject.data.SerieItemCatalog;

import java.util.List;

@Dao
public interface PeliCategoryDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProductPeli(PeliculaItemCatalog product);

    @Update
    void updatePeli(PeliculaItemCatalog product);

    @Delete
    void deletePeli(PeliculaItemCatalog product);

    @Query("SELECT * FROM productsPelis")
    List<PeliculaItemCatalog> loadPelis();

    @Query("SELECT * FROM productsPelis WHERE id = :id LIMIT 1")
    PeliculaItemCatalog loadPeli(int id);

    @Query("SELECT * FROM productsPelis WHERE category_id=:categoryId")
    List<PeliculaItemCatalog> loadPelis(final int categoryId);
}
