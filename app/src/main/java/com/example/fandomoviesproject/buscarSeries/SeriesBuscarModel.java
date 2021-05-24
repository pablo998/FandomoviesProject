package com.example.fandomoviesproject.buscarSeries;

import android.util.Log;

import com.example.fandomoviesproject.data.RepositoryContract;

public class SeriesBuscarModel implements SeriesBuscarContract.Model {

    public static String TAG = SeriesBuscarModel.class.getSimpleName();

    private RepositoryContract repository;

    public SeriesBuscarModel(RepositoryContract repository){
        this.repository = repository;
    }

    @Override
    public void fetchSerieBuscarData(RepositoryContract.GetSeriesListCallback callback) {
        RepositoryContract.FetchCatalogDataSerieCallback callback1 = null;

        Log.e(TAG, "fetchSeriesListData()");
        repository.loadCatalogSerie(true,callback1);
        repository.getAllSeriesList(callback);
    }
}

