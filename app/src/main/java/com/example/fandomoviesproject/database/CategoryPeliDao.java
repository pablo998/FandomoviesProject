package com.example.fandomoviesproject.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;

import java.util.List;


@Dao
public interface CategoryPeliDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategory(CategoryItemCatalog category);

    @Update
    void updateCategoryPeli(CategoryItemCatalog category);

    @Delete
    void deleteCategoryPeli(CategoryItemCatalog category);

    @Query("SELECT * FROM categoriesPelis")
    List<CategoryItemCatalog> loadCategoriesPeli();

    @Query("SELECT * FROM categoriesPelis WHERE id = :id LIMIT 1")
    CategoryItemCatalog loadCategoryPeli(int id);
}
