package com.example.fandomoviesproject.buscarSeries;

//TODO descomentar import com.example.recyclerview.data.RepositoryContract;

public class SeriesBuscarModel implements SeriesBuscarContract.Model {

    public static String TAG = SeriesBuscarModel.class.getSimpleName();

    // TODO DE AQUI HASTA ABAJO QUEDA PENDIENTE HASTA QUE SE IMPLEMENTE EL REPOSITORIO

    /*
    private RepositoryContract repository;

    public SeriesBuscarModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void fetchSeriesBuscarData(
            final RepositoryContract.GetCategoryListCallback callback) {

        Log.e(TAG, "fetchCategoryListData()");

        repository.loadCatalog(new RepositoryContract.FetchCatalogDataCallback() {

            @Override
            public void onCatalogDataFetched(boolean error) {
                if(!error) {
                    repository.getSeriesList(callback);
                }
            }
        });

    }

     */

}

