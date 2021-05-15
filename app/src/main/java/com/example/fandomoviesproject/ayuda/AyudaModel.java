package com.example.fandomoviesproject.ayuda;





public class AyudaModel implements AyudaContract.Model {

    public static String TAG = AyudaModel.class.getSimpleName();


    /*
    private RepositoryContract repository;

    public AyudaModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void fetchAyudaData(
            final RepositoryContract.GetCategoryListCallback callback) {

        Log.e(TAG, "fetchAyudaData()");

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
