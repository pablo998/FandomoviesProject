package com.example.fandomoviesproject.registrarse;





public class RegistrarseModel implements RegistrarseContract.Model {

    public static String TAG = RegistrarseModel.class.getSimpleName();


    /*
    private RepositoryContract repository;

    public RegistrarseModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void comprobarQueNoEstaEmail(
            final RepositoryContract.GetCategoryListCallback callback) {

        Log.e(TAG, "comprobarQueNoEstaEmail()");

        repository.loadCatalog(new RepositoryContract.FetchCatalogDataCallback() {

            @Override
            public void onCatalogDataFetched(boolean error) {
                if(!error) {
                    repository.getSeriesList(callback);
                }
            }
        });

    }

    @Override
    public void comprobarQueNoEstaNumMovil(
            final RepositoryContract.GetCategoryListCallback callback) {

        Log.e(TAG, "comprobarQueNoEstaNumMovil()");

        repository.loadCatalog(new RepositoryContract.FetchCatalogDataCallback() {

            @Override
            public void onCatalogDataFetched(boolean error) {
                if(!error) {
                    repository.getSeriesList(callback);
                }
            }
        });

    }

    @Override
    public void guardarEnBaseDeDatos(
            final RepositoryContract.GetCategoryListCallback callback) {

        Log.e(TAG, "guardarEnBaseDeDatos()");

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
