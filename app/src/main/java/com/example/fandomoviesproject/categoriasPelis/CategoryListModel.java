package com.example.fandomoviesproject.categoriasPelis;

import android.util.Log;
import com.example.fandomoviesproject.data.RepositoryContract;

public class CategoryListModel implements CategoryListContract.Model {

    public static String TAG = CategoryListModel.class.getSimpleName();

    private RepositoryContract repository;

    public CategoryListModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void fetchCategoryListData(
            final RepositoryContract.GetCategoryPeliListCallback callback) {

        Log.e(TAG, "fetchCategoryListData()");

        repository.loadCatalogPeli(
                true, new RepositoryContract.FetchCatalogDataPeliCallback() {

                    @Override
                    public void onCatalogDataPeliFetched(boolean error) {
                        if(!error) {
                            repository.getCategoryPeliList(callback);
                        }
                    }
                });

    }

}