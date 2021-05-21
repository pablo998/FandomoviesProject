package com.example.fandomoviesproject.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fandomoviesproject.data.SerieItemCatalog;

import java.util.List;

@Dao
public interface SerieCategoryDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduct(SerieItemCatalog product);

    @Update
    void updateSerie(SerieItemCatalog product);

    @Delete
    void deleteSerie(SerieItemCatalog product);

    @Query("SELECT * FROM productsSeries")
    List<SerieItemCatalog> loadSeries();

    @Query("SELECT * FROM productsSeries WHERE id = :id LIMIT 1")
    SerieItemCatalog loadSerie(int id);

    @Query("SELECT * FROM productsSeries WHERE category_id=:categoryId")
    List<SerieItemCatalog> loadSeries(final int categoryId);
}
