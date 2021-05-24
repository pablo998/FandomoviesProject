package com.example.fandomoviesproject.app;

import com.example.fandomoviesproject.categoriasDocu.CategoryDocuListState;
import com.example.fandomoviesproject.compras.ComprasState;
import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;
import com.example.fandomoviesproject.data.ComprasItem;
import com.example.fandomoviesproject.data.DocuItemCatalog;
import com.example.fandomoviesproject.data.FavoritoItem;
import com.example.fandomoviesproject.docuDetail.DocuDetailState;
import com.example.fandomoviesproject.docusDeUnaCategoria.DocuListState;
import com.example.fandomoviesproject.favoritos.FavoritosState;
import com.example.fandomoviesproject.mainActivity.MainActivityState;
import com.example.fandomoviesproject.menu.MenuState;

import com.example.fandomoviesproject.data.DocuItem;

import com.example.fandomoviesproject.data.PeliculaItemCatalog;
import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;
import com.example.fandomoviesproject.data.SerieItemCatalog;


import com.example.fandomoviesproject.buscarPelis.PelisBuscarState;
import com.example.fandomoviesproject.buscarSeries.SeriesBuscarState;
import com.example.fandomoviesproject.buscarDocus.DocusBuscarState;

import com.example.fandomoviesproject.categoriasSeries.CategorySerieListState;
import com.example.fandomoviesproject.perfil.perfilState;
import com.example.fandomoviesproject.registrarse.RegistrarseState;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListState;
import com.example.fandomoviesproject.serieDetail.SerieDetailState;

import com.example.fandomoviesproject.categoriasPelis.CategoryListState;
import com.example.fandomoviesproject.peliculaDetail.PeliculaDetailState;
import com.example.fandomoviesproject.peliculasDeUnaCategoria.PeliculaListState;

import java.util.ArrayList;

public class AppMediator {

    //Peliculas
    private PeliculaListState peliculaListState = new PeliculaListState();
    private PeliculaDetailState peliculaDetailState = new PeliculaDetailState();
    private CategoryListState productCategoryListState = new CategoryListState();

    //Series
    private CategorySerieListState CategorySerieListState = new CategorySerieListState();
    private SerieListState SerieListState = new SerieListState();
    private SerieDetailState serieDetailState = new SerieDetailState();

    //Compras , Favoritos y Registrarse
    private FavoritosState favoritosState = new FavoritosState();
    private ComprasState comprasState = new ComprasState();
    private RegistrarseState registrarseState = new RegistrarseState();

    //MainActivity
    private MainActivityState mainActivityState = new MainActivityState();

    //Documentales
    private CategoryDocuListState categoryDocuListState = new CategoryDocuListState();
    private DocuListState docuListState = new DocuListState();
    private DocuDetailState docuDetailState = new DocuDetailState();

    //Pantallas buscar
    private PelisBuscarState pelisBuscarState = new PelisBuscarState();
    private DocusBuscarState docusBuscarState = new DocusBuscarState();
    private SeriesBuscarState seriesBuscarState = new SeriesBuscarState();

    //Peliculas
    private PeliculaItemCatalog product2;
    private CategoryItemCatalog product1;
    //Series
    private CategorySerieItemCatalog product1Serie;
    private SerieItemCatalog product2Serie;
    //Documentales
    private CategoryDocuItemCatalog product1Docu;
    private DocuItemCatalog product2Docu;


    private PeliculaItemCatalog pelicula;
    private DocuItem documental;

    private FavoritoItem favoritoItem;
    private ArrayList<FavoritoItem> favoritosList;
    private ArrayList<ComprasItem> comprasList;
    private ComprasItem comprasItem;

    private MenuState menuState;
    private static AppMediator INSTANCE;

    private perfilState perfilState;

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

    //Peliculas
    public PeliculaListState getPeliculaListState() {
        return peliculaListState;
    }
    public PeliculaDetailState getPeliculaDetailState() {
        return peliculaDetailState;
    }
    public CategoryListState getCategoryListState() {
        return productCategoryListState;
    }

    //Series
    public CategorySerieListState getCategorySerieListState() {
        return CategorySerieListState;
    }
    public SerieListState getSerieListState() {
        return SerieListState;
    }
    public SerieDetailState getSerieDetailState() {
        return serieDetailState;
    }

    //Documentales
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

    public FavoritosState getFavoritosState() {
        return favoritosState;
    }
    public ComprasState getComprasState() {
        return comprasState;
    }
    public RegistrarseState getRegistrarseState() {
        return registrarseState;
    }
    public MainActivityState getMainActivityState() {
        return mainActivityState;
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

    //pantalla del perfil
    public perfilState getPerfilState(){return perfilState;}

    public void setCategoriaInPeliculaListScreen(CategoryItemCatalog item) {
        product1 = item;
    }
    public void setPeliculaInPeliculaDetailScreen(PeliculaItemCatalog item) {
        product2 = item;
    }


    public void setCategoriaInSerieListScreen(CategorySerieItemCatalog item) { product1Serie = item; }
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



    public void setLiked(FavoritoItem item){
        if(favoritosList == null) {favoritosList = new ArrayList<>();}
        FavoritoItem newFavoritoItem = new FavoritoItem(item.getTitle(), item.getInfo(), 0, 0);
        favoritoItem = newFavoritoItem;
        favoritosList.add(newFavoritoItem);
        favoritoItem = null;
    }

    public void setHeComprado(ComprasItem item){
        if(comprasList == null) {comprasList = new ArrayList<>();}
        ComprasItem newComprasItem = new ComprasItem(item.getTitle(), item.getInfo(), 0);
        comprasItem = newComprasItem;
        comprasList.add(newComprasItem);
        comprasItem = null;
    }



    public ArrayList<FavoritoItem> getLikedItems(){
        return favoritosList;
    }

    public ArrayList<ComprasItem> getCompradoItems(){
        return comprasList;
    }

}
