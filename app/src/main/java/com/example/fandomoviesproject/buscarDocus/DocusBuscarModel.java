package com.example.fandomoviesproject.buscarDocus;

//TODO descomentar import com.example.recyclerview.data.RepositoryContract;

public class DocusBuscarModel implements DocusBuscarContract.Model {

    public static String TAG = DocusBuscarModel.class.getSimpleName();

    // TODO DE AQUI HASTA ABAJO QUEDA PENDIENTE HASTA QUE SE IMPLEMENTE EL REPOSITORIO

    /*
    private RepositoryContract repository;

    public DocusBuscarModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void fetchDocusBuscarData(
            final RepositoryContract.GetCategoryListCallback callback) {

        Log.e(TAG, "fetchCategoryListData()");

        repository.loadCatalog(new RepositoryContract.FetchCatalogDataCallback() {

            @Override
            public void onCatalogDataFetched(boolean error) {
                if(!error) {
                    repository.getDocusList(callback);
                }
            }
        });

    }

     */

}


