package com.example.fandomoviesproject.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fandomoviesproject.data.CategorySerieItemCatalog;

import java.util.List;


@Dao
public interface CategorySerieDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategory(CategorySerieItemCatalog category);

    @Update
    void updateCategorySerie(CategorySerieItemCatalog category);

    @Delete
    void deleteCategorySerie(CategorySerieItemCatalog category);

    @Query("SELECT * FROM categoriesSeries")
    List<CategorySerieItemCatalog> loadCategoriesSeries();

    @Query("SELECT * FROM categoriesSeries WHERE id = :id LIMIT 1")
    CategorySerieItemCatalog loadCategorySerie(int id);
}
