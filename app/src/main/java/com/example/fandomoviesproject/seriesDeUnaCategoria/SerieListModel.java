package com.example.fandomoviesproject.seriesDeUnaCategoria;

import android.util.Log;

import com.example.fandomoviesproject.data.CategorySerieItemCatalog;
import com.example.fandomoviesproject.data.RepositoryContract;


public class SerieListModel implements SerieListContract.Model {

    public static String TAG = SerieListModel.class.getSimpleName();


    private RepositoryContract repository;

    public SerieListModel(RepositoryContract repository){
        this.repository = repository;
    }

    @Override
    public void fetchSerieListData(
            CategorySerieItemCatalog category, RepositoryContract.GetSeriesListCallback callback) {

        Log.e(TAG, "fetchSeriesListData()");
        repository.getSeriesList(category, callback);
    }
}

