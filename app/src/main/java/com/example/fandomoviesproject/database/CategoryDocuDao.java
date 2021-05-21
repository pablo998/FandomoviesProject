package com.example.fandomoviesproject.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;
import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;

import java.util.List;


@Dao
public interface CategoryDocuDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategory(CategoryDocuItemCatalog category);

    @Update
    void updateCategoryDocu(CategoryDocuItemCatalog category);

    @Delete
    void deleteCategoryDocu(CategoryDocuItemCatalog category);

    @Query("SELECT * FROM categoriesDocumentales")
    List<CategoryDocuItemCatalog> loadCategoriesDocu();

    @Query("SELECT * FROM categoriesDocumentales WHERE id = :id LIMIT 1")
    CategoryDocuItemCatalog loadCategoryDocu(int id);
}
