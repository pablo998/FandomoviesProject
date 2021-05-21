package com.example.fandomoviesproject.categoriasSeries;

import android.util.Log;

import com.example.fandomoviesproject.data.RepositoryContract;

import com.example.fandomoviesproject.data.RepositoryContract;

public class CategorySerieListModel implements CategorySerieListContract.Model {

    public static String TAG = CategorySerieListModel.class.getSimpleName();

    private RepositoryContract repository;

    public CategorySerieListModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void fetchCategorySerieListData(
            final RepositoryContract.GetCategorySerieListCallback callback) {

        Log.e(TAG, "fetchCategorySerieListData()");

        repository.loadCatalogSerie(
                true, new RepositoryContract.FetchCatalogDataSerieCallback() {

                    @Override
                    public void onCatalogDataSerieFetched(boolean error) {
                        if(!error) {
                            repository.getCategorySerieList(callback);
                        }
                    }
                });

    }

}

