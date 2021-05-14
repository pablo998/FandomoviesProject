package com.example.fandomoviesproject.app;

import com.example.fandomoviesproject.categoriasDocu.CategoryDocuListState;
import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;
import com.example.fandomoviesproject.data.DocuItemCatalog;
import com.example.fandomoviesproject.docuDetail.DocuDetailState;
import com.example.fandomoviesproject.docusDeUnaCategoria.DocuListState;
import com.example.fandomoviesproject.menu.MenuState;

import com.example.fandomoviesproject.data.DocuItem;
import com.example.fandomoviesproject.data.SerieItem;

import com.example.fandomoviesproject.data.PeliculaItemCatalog;
import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;
import com.example.fandomoviesproject.data.SerieItemCatalog;


import com.example.fandomoviesproject.buscarPelis.PelisBuscarState;
import com.example.fandomoviesproject.buscarSeries.SeriesBuscarState;
import com.example.fandomoviesproject.buscarDocus.DocusBuscarState;

import com.example.fandomoviesproject.categoriasSeries.CategorySerieListState;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListState;
import com.example.fandomoviesproject.serieDetail.SerieDetailState;

import com.example.fandomoviesproject.categoriasPelis.CategoryListState;
import com.example.fandomoviesproject.peliculaDetail.PeliculaDetailState;
import com.example.fandomoviesproject.peliculasDeUnaCategoria.PeliculaListState;

public class AppMediator {


    private PeliculaListState peliculaListState = new PeliculaListState();
    private PeliculaDetailState peliculaDetailState = new PeliculaDetailState();
    private CategoryListState productCategoryListState = new CategoryListState();


    private CategorySerieListState CategorySerieListState = new CategorySerieListState();
    private SerieListState SerieListState = new SerieListState();
    private SerieDetailState serieDetailState = new SerieDetailState();

    private CategoryDocuListState categoryDocuListState = new CategoryDocuListState();
    private DocuListState docuListState = new DocuListState();
    private DocuDetailState docuDetailState = new DocuDetailState();

    private PelisBuscarState pelisBuscarState = new PelisBuscarState();
    private DocusBuscarState docusBuscarState = new DocusBuscarState();
    private SeriesBuscarState seriesBuscarState = new SeriesBuscarState();

    private PeliculaItemCatalog product2;
    private CategoryItemCatalog product1;
    private CategorySerieItemCatalog product1Serie;
    private SerieItemCatalog product2Serie;
    private CategoryDocuItemCatalog product1Docu;
    private DocuItemCatalog product2Docu;


    private PeliculaItemCatalog pelicula;
    private DocuItem documental;
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

    public CategorySerieListState getCategorySerieListState() {
        return CategorySerieListState;
    }
    public SerieListState getSerieListState() {
        return SerieListState;
    }

    public SerieDetailState getSerieDetailState() {
        return serieDetailState;
    }


    public DocuDetailState getDocuDetailState() {
        return docuDetailState;
    }
    public CategoryDocuListState getCategoryDocuListState() {
        return categoryDocuListState;
    }
    public DocuListState getDocuListState() {
        return docuListState;
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

    public void setCategoriaInPeliculaListScreen(CategoryItemCatalog item) {
        product1 = item;
    }

    public void setPeliculaInPeliculaDetailScreen(PeliculaItemCatalog item) {
        product2 = item;
    }

    public void setCategoriaInSerieListScreen(CategorySerieItemCatalog item) {
        product1Serie = item;
    }

    public void setSerieInSerieDetailScreen(SerieItemCatalog item) {
        product2Serie = item;
    }

    public void setCategoriaInDocuListScreen(CategoryDocuItemCatalog item) {
        product1Docu = item;
    }
    public void setDocuInDocuDetailScreen(DocuItemCatalog item) {
        product2Docu = item;
    }



    public CategorySerieItemCatalog getProduct1Serie() {
        CategorySerieItemCatalog item = product1Serie;
        //product1Serie = null;
        return item;
    }

    public SerieItemCatalog getProduct2Serie() {
        SerieItemCatalog item = product2Serie;
        //product2Serie = null;
        return item;
    }

    public CategoryDocuItemCatalog getProduct1Docu() {
        CategoryDocuItemCatalog item = product1Docu;
        //product1Serie = null;
        return item;
    }

    public DocuItemCatalog getProduct2Docu() {
        DocuItemCatalog item = product2Docu;
        //product2Serie = null;
        return item;
    }

    public void setPelicula(PeliculaItemCatalog item) {
        pelicula = item;
    }

    public PeliculaItemCatalog getPelicula() {
        PeliculaItemCatalog item = pelicula;
        //pelicula = null;
        return item;
    }

    public void setDocumental(DocuItem item) {
        documental = item;
    }

    public DocuItem getDocumental() {
        DocuItem item = documental;
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
