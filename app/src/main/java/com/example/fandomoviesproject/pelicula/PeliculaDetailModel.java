package com.example.fandomoviesproject.pelicula;

//import com.example.recyclerview.data.RepositoryContract;

public class PeliculaDetailModel implements PeliculaDetailContract.Model {

    public static String TAG = PeliculaDetailModel.class.getSimpleName();

    public PeliculaDetailModel() {

    }

    // TODO DE AQUI HASTA ABAJO QUEDA PENDIENTE HASTA QUE SE IMPLEMENTE EL REPOSITORIO

    /*
    private RepositoryContract repository;

    public PeliculaDetailModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void fetchPeliculaDetailData(
            final RepositoryContract.GetPeliculaDetailCallback callback) {

        Log.e(TAG, "fetchPeliculaDetailData()");

        repository.loadCatalog(new RepositoryContract.FetchCatalogDataCallback() {

            @Override
            public void onCatalogDataFetched(boolean error) {
                if(!error) {
                    repository.getPeliculaDetail(callback);
                }
            }
        });

    }

     */

}

