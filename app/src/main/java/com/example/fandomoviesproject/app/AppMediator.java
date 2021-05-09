package com.example.fandomoviesproject.app;

import com.example.fandomoviesproject.menu.MenuState;

import com.example.fandomoviesproject.data.PeliculaItem;
import com.example.fandomoviesproject.data.CategoryItem;

import com.example.fandomoviesproject.categoriesFandomovies.CategoryListState;
import com.example.fandomoviesproject.pelicula.PeliculaDetailState;
import com.example.fandomoviesproject.peliculas.PeliculaListState;

public class AppMediator {


    private PeliculaListState peliculaListState = new PeliculaListState();
    private PeliculaDetailState peliculaDetailState = new PeliculaDetailState();
    private CategoryListState productCategoryListState = new CategoryListState();

    private PeliculaItem product2;
    private CategoryItem product1;

    private MenuState menuState;
    private static AppMediator INSTANCE;


    private AppMediator() {

        menuState = new MenuState();
    }

    public static void resetInstance() {
        INSTANCE = null;
    }


    public static AppMediator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppMediator();
        }

        return INSTANCE;
    }

    public MenuState getMenuState() {
        return menuState;
    }


    public PeliculaListState getPeliculaListState() {
        return peliculaListState;
    }

    public PeliculaDetailState getPeliculaDetailState() {
        return peliculaDetailState;
    }

    public CategoryListState getCategoryListState() {
        return productCategoryListState;
    }

    public CategoryItem getProduct1() {
        CategoryItem item = product1;
        //product1 = null;
        return item;
    }

    public PeliculaItem getProduct2() {
        PeliculaItem item = product2;
        //product2 = null;
        return item;
    }

    public void setPeliculaInPeliculaListScreen(CategoryItem item) {
        product1 = item;
    }

    public void setPeliculaInPeliculaDetailScreen(PeliculaItem item) {
        product2 = item;
    }


}
