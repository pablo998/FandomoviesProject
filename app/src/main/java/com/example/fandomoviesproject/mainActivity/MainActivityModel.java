package com.example.fandomoviesproject.mainActivity;


public class MainActivityModel implements MainActivityContract.Model {

    public static String TAG = MainActivityModel.class.getSimpleName();


    /*
    private RepositoryContract repository;

    public MainActivityModel(RepositoryContract repository) {
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
     */

}
