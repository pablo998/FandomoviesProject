package com.example.fandomoviesproject.data;

import java.util.List;

public interface RepositoryContract {


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

}
