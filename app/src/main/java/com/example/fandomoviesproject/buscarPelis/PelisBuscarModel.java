package com.example.fandomoviesproject.buscarPelis;

//TODO descomentar
//import com.example.recyclerview.data.RepositoryContract;

public class PelisBuscarModel implements PelisBuscarContract.Model {

    public static String TAG = PelisBuscarModel.class.getSimpleName();

    // TODO DE AQUI HASTA ABAJO QUEDA PENDIENTE HASTA QUE SE IMPLEMENTE EL REPOSITORIO

    /*
    private RepositoryContract repository;

    public PelisBuscarModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void fetchPelisBuscarData(
            final RepositoryContract.GetCategoryListCallback callback) {

        Log.e(TAG, "fetchCategoryListData()");

        repository.loadCatalog(new RepositoryContract.FetchCatalogDataCallback() {

            @Override
            public void onCatalogDataFetched(boolean error) {
                if(!error) {
                    repository.getPelisList(callback);
                }
            }
        });

    }

     */

}

