package com.example.fandomoviesproject.peliculasDeUnaCategoria;

import android.util.Log;


import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.data.RepositoryContract;

public class PeliculaListModel implements PeliculaListContract.Model {

    public static String TAG = PeliculaListModel.class.getSimpleName();

    private RepositoryContract repository;

    public PeliculaListModel(RepositoryContract repository){
        this.repository = repository;
    }

    @Override
    public void fetchPeliculaListData(
            CategoryItemCatalog category, RepositoryContract.GetPelisListCallback callback) {

        Log.e(TAG, "fetchPelisListData()");
        repository.getPelisList(category, callback);
    }
}

