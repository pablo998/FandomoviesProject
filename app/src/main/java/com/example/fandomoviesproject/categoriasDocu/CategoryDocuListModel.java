package com.example.fandomoviesproject.categoriasDocu;

import android.util.Log;

import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;
import com.example.fandomoviesproject.data.RepositoryContract;

import java.util.ArrayList;
import java.util.List;

public class CategoryDocuListModel implements CategoryDocuListContract.Model {

    public static String TAG = CategoryDocuListModel.class.getSimpleName();

    private RepositoryContract repository;

    public CategoryDocuListModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void fetchCategoryDocuListData(
            final RepositoryContract.GetCategoryDocuListCallback callback) {

        Log.e(TAG, "fetchCategoryDocuListData()");

        repository.loadCatalogDocu(
                true, new RepositoryContract.FetchCatalogDataDocuCallback() {

                    @Override
                    public void onCatalogDataDocuFetched(boolean error) {
                        if(!error) {
                            repository.getCategoryDocuList(callback);
                        }
                    }
                });

    }

}