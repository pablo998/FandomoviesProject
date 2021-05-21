package com.example.fandomoviesproject.data;

import java.util.List;

public interface RepositoryContract {

    interface FetchCatalogDataSerieCallback {
        void onCatalogDataSerieFetched(boolean error);
    }

    interface GetSeriesListCallback {
        void setSeriesList(List<SerieItemCatalog> series);
    }

    interface GetSerieCallback {
        void setSerie(SerieItemCatalog serie);
    }

    interface GetCategorySerieListCallback {
        void setCategorySerieList(List<CategorySerieItemCatalog> categories);
    }

    interface GetCategorySerieCallback {
        void setCategorySerie(CategorySerieItemCatalog category);
    }

    interface DeleteCategorySerieCallback {
        void onCategorySerieDeleted();
    }

    interface UpdateCategorySerieCallback {
        void onCategorySerieUpdated();
    }

    interface DeleteSerieCallback {
        void onSerieDeleted();
    }

    interface UpdateSerieCallback {
        void onSerieUpdated();
    }


    void loadCatalogSerie(
            boolean clearFirst, Repository.FetchCatalogDataSerieCallback callback);

    void getSeriesList(
            CategorySerieItemCatalog category, Repository.GetSeriesListCallback callback);

    void getSeriesList(
            int categoryId, Repository.GetSeriesListCallback callback);

    void getSerie(int id, Repository.GetSerieCallback callback);
    void getCategorySerie(int id, Repository.GetCategorySerieCallback callback);
    void getCategorySerieList(Repository.GetCategorySerieListCallback callback);

    void deleteSerie(
            SerieItemCatalog product, Repository.DeleteSerieCallback callback);

    void updateSerie(
            SerieItemCatalog product, Repository.UpdateSerieCallback callback);

    void deleteCategorySerie(
            CategorySerieItemCatalog category, Repository.DeleteCategorySerieCallback callback);

    void updateCategorySerie(
            CategorySerieItemCatalog category, Repository.UpdateCategorySerieCallback callback);


    /*
    ---------------------------- DE AQUÍ HACIA ARRIBA SERIES, HACIA ABAJO PELIS -----------------------------------------
     */


    interface FetchCatalogDataPeliCallback {
        void onCatalogDataPeliFetched(boolean error);
    }

    interface GetPelisListCallback {
        void setPelisList(List<PeliculaItemCatalog> pelis);
    }

    interface GetPeliCallback {
        void setPeli(PeliculaItemCatalog peli);
    }

    interface GetCategoryPeliListCallback {
        void setCategoryPeliList(List<CategoryItemCatalog> categories);
    }

    interface GetCategoryPeliCallback {
        void setCategoryPeli(CategoryItemCatalog category);
    }

    interface DeleteCategoryPeliCallback {
        void onCategoryPeliDeleted();
    }

    interface UpdateCategoryPeliCallback {
        void onCategoryPeliUpdated();
    }

    interface DeletePeliCallback {
        void onPeliDeleted();
    }

    interface UpdatePeliCallback {
        void onPeliUpdated();
    }


    void loadCatalogPeli(
            boolean clearFirst, Repository.FetchCatalogDataPeliCallback callback);

    void getPelisList(
            CategoryItemCatalog category, Repository.GetPelisListCallback callback);

    void getPelisList(
            int categoryId, Repository.GetPelisListCallback callback);

    void getPeli(int id, Repository.GetPeliCallback callback);
    void getCategoryPeli(int id, Repository.GetCategoryPeliCallback callback);
    void getCategoryPeliList(Repository.GetCategoryPeliListCallback callback);

    void deletePeli(
            PeliculaItemCatalog product, Repository.DeletePeliCallback callback);

    void updatePeli(
            PeliculaItemCatalog product, Repository.UpdatePeliCallback callback);

    void deleteCategoryPeli(
            CategoryItemCatalog category, Repository.DeleteCategoryPeliCallback callback);

    void updateCategoryPeli(
            CategoryItemCatalog category, Repository.UpdateCategoryPeliCallback callback);

     /*
    ---------------------------- DE AQUÍ HACIA ARRIBA PELIS, HACIA ABAJO DOCUS -----------------------------------------
     */

    interface FetchCatalogDataDocuCallback {
        void onCatalogDataDocuFetched(boolean error);
    }

    interface GetDocusListCallback {
        void setDocusList(List<DocuItemCatalog> docus);
    }

    interface GetDocuCallback {
        void setDocu(DocuItemCatalog docu);
    }

    interface GetCategoryDocuListCallback {
        void setCategoryDocuList(List<CategoryDocuItemCatalog> categories);
    }

    interface GetCategoryDocuCallback {
        void setCategoryDocu(CategoryDocuItemCatalog category);
    }

    interface DeleteCategoryDocuCallback {
        void onCategoryDocuDeleted();
    }

    interface UpdateCategoryDocuCallback {
        void onCategoryDocuUpdated();
    }

    interface DeleteDocuCallback {
        void onDocuDeleted();
    }

    interface UpdateDocuCallback {
        void onDocuUpdated();
    }


    void loadCatalogDocu(
            boolean clearFirst, Repository.FetchCatalogDataDocuCallback callback);

    void getDocusList(
            CategoryDocuItemCatalog category, Repository.GetDocusListCallback callback);

    void getDocusList(
            int categoryId, Repository.GetDocusListCallback callback);

    void getDocu(int id, Repository.GetDocuCallback callback);
    void getCategoryDocu(int id, Repository.GetCategoryDocuCallback callback);
    void getCategoryDocuList(Repository.GetCategoryDocuListCallback callback);

    void deleteDocu(
            DocuItemCatalog product, Repository.DeleteDocuCallback callback);

    void updateDocu(
            DocuItemCatalog product, Repository.UpdateDocuCallback callback);

    void deleteCategoryDocu(
            CategoryDocuItemCatalog category, Repository.DeleteCategoryDocuCallback callback);

    void updateCategoryDocu(
            CategoryDocuItemCatalog category, Repository.UpdateCategoryDocuCallback callback);


}

