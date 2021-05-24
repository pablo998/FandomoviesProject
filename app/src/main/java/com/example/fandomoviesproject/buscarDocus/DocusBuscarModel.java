package com.example.fandomoviesproject.buscarDocus;


import android.util.Log;

import com.example.fandomoviesproject.data.RepositoryContract;

public class DocusBuscarModel implements DocusBuscarContract.Model {

    public static String TAG = DocusBuscarModel.class.getSimpleName();


    private RepositoryContract repository;

    public DocusBuscarModel(RepositoryContract repository){
        this.repository = repository;
    }

    @Override
    public void fetchDocuBuscarData(RepositoryContract.GetDocusListCallback callback) {
        RepositoryContract.FetchCatalogDataDocuCallback callback1 = null;

        Log.e(TAG, "fetchDocusListData()");
        repository.loadCatalogDocu(true,callback1);
        repository.getAllDocusList(callback);
    }
}


