package com.example.fandomoviesproject.buscarPelis;

import android.util.Log;

import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.data.RepositoryContract;

public class PelisBuscarModel implements PelisBuscarContract.Model {

    public static String TAG = PelisBuscarModel.class.getSimpleName();

    private RepositoryContract repository;

    public PelisBuscarModel(RepositoryContract repository){
        this.repository = repository;
    }

    @Override
    public void fetchPeliBuscarData(RepositoryContract.GetPelisListCallback callback) {
        RepositoryContract.FetchCatalogDataPeliCallback callback1 = null;

        Log.e(TAG, "fetchPelisListData()");
        repository.loadCatalogPeli(true,callback1);
        repository.getAllPelisList(callback);
    }
}
