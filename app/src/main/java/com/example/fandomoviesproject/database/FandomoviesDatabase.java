package com.example.fandomoviesproject.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;
import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;
import com.example.fandomoviesproject.data.DocuItemCatalog;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;
import com.example.fandomoviesproject.data.SerieItemCatalog;


@Database(entities = { CategoryItemCatalog.class, PeliculaItemCatalog.class,
        CategorySerieItemCatalog.class, SerieItemCatalog.class, CategoryDocuItemCatalog.class,
        DocuItemCatalog.class}, version = 1)
public abstract class FandomoviesDatabase extends RoomDatabase {

    public abstract  CategoryPeliDao categoryPeliDao();
    public abstract PeliCategoryDao peliCategoryDao();

    public abstract  CategorySerieDao categorySerieDao();
    public abstract SerieCategoryDao serieCategoryDao();

    public abstract  CategoryDocuDao categoryDocuDao();
    public abstract DocuCategoryDao docuCategoryDao();


}
