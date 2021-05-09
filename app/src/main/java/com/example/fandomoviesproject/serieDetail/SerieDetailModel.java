package com.example.fandomoviesproject.serieDetail;

//import com.example.recyclerview.data.RepositoryContract;

import com.example.fandomoviesproject.serieDetail.SerieDetailContract;

public class SerieDetailModel implements SerieDetailContract.Model {

    public static String TAG = SerieDetailModel.class.getSimpleName();

    public SerieDetailModel() {

    }

    // TODO DE AQUI HASTA ABAJO QUEDA PENDIENTE HASTA QUE SE IMPLEMENTE EL REPOSITORIO

    /*
    private RepositoryContract repository;

    public SerieDetailModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void fetchSerieDetailData(
            final RepositoryContract.GetSerieDetailCallback callback) {

        Log.e(TAG, "fetchSerieDetailData()");

        repository.loadCatalog(new RepositoryContract.FetchCatalogDataCallback() {

            @Override
            public void onCatalogDataFetched(boolean error) {
                if(!error) {
                    repository.getSerieDetail(callback);
                }
            }
        });

    }

     */

}

