package com.example.fandomoviesproject.app;

import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.menu.MenuState;

import com.example.fandomoviesproject.data.DocumentalItem;
import com.example.fandomoviesproject.data.SerieItem;

import com.example.fandomoviesproject.data.PeliculaItemCatalog;

import com.example.fandomoviesproject.buscarPelis.PelisBuscarState;
import com.example.fandomoviesproject.buscarSeries.SeriesBuscarState;
import com.example.fandomoviesproject.buscarDocus.DocusBuscarState;

import com.example.fandomoviesproject.categoriasPelis.CategoryListState;
import com.example.fandomoviesproject.peliculaDetail.PeliculaDetailState;
import com.example.fandomoviesproject.peliculasDeUnaCategoria.PeliculaListState;

public class AppMediator {


    private PeliculaListState peliculaListState = new PeliculaListState();
    private PeliculaDetailState peliculaDetailState = new PeliculaDetailState();
    private CategoryListState productCategoryListState = new CategoryListState();

    private PelisBuscarState pelisBuscarState = new PelisBuscarState();
    private DocusBuscarState docusBuscarState = new DocusBuscarState();
    private SeriesBuscarState seriesBuscarState = new SeriesBuscarState();

    private PeliculaItemCatalog product2;
    private CategoryItemCatalog product1;

    private PeliculaItemCatalog pelicula;
    private DocumentalItem documental;
    private SerieItem serie;

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

    public PelisBuscarState getPelisBuscarState() {
        return pelisBuscarState;
    }
    public DocusBuscarState getDocusBuscarState() {
        return docusBuscarState;
    }
    public SeriesBuscarState getSeriesBuscarState() {
        return seriesBuscarState;
    }

    public CategoryItemCatalog getProduct1() {
        CategoryItemCatalog item = product1;
        //product1 = null;
        return item;
    }

    public PeliculaItemCatalog getProduct2() {
        PeliculaItemCatalog item = product2;
        //product2 = null;
        return item;
    }

    public void setPeliculaInPeliculaListScreen(CategoryItemCatalog item) {
        product1 = item;
    }

    public void setPeliculaInPeliculaDetailScreen(PeliculaItemCatalog item) {
        product2 = item;
    }

    public void setPelicula(PeliculaItemCatalog item) {
        pelicula = item;
    }

    public PeliculaItemCatalog getPelicula() {
        PeliculaItemCatalog item = pelicula;
        //pelicula = null;
        return item;
    }

    public void setDocumental(DocumentalItem item) {
        documental = item;
    }

    public DocumentalItem getDocumental() {
        DocumentalItem item = documental;
        //documental = null;
        return item;
    }

    public void setSerie(SerieItem item) {
        serie = item;
    }

    public SerieItem getSerie() {
        SerieItem item = serie;
        //serie = null;
        return item;
    }


}
