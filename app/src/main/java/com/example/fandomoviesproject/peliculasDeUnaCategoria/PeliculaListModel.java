package com.example.fandomoviesproject.peliculasDeUnaCategoria;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.example.fandomoviesproject.data.PeliculaItemCatalog;
//import com.example.recyclerview.data.RepositoryContract;

public class PeliculaListModel implements PeliculaListContract.Model {

    public static String TAG = PeliculaListModel.class.getSimpleName();

    private final List<PeliculaItemCatalog> itemList = new ArrayList<>();
    private final int COUNT = 20;

    public PeliculaListModel(){

    }

    // TODO DE AQUI HASTA ABAJO QUEDA PENDIENTE HASTA QUE SE IMPLEMENTE EL REPOSITORIO

    /*
    private RepositoryContract repository;

    public PeliculaListModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void fetchPeliculaListData(
            final RepositoryContract.GetPeliculaListCallback callback) {

        Log.e(TAG, "fetchPeliculaListData()");

        repository.loadCatalog(new RepositoryContract.FetchCatalogDataCallback() {

            @Override
            public void onCatalogDataFetched(boolean error) {
                if(!error) {
                    repository.getPeliculaList(callback);
                }
            }
        });

    }

     */

    @Override
    public void createItemList (int idReceived){
        // Add some sample items
        for (int index = 1; index <= COUNT; index++) {
            addProduct(createProduct(index, idReceived));
        }
    }

    @Override
    public List<PeliculaItemCatalog> fetchPeliculaListData() {
        Log.e(TAG, "fetchPeliculaListData()");
        return itemList;
    }

    private void addProduct(PeliculaItemCatalog item) {
        itemList.add(item);
    }


    private PeliculaItemCatalog createProduct(int position, int idReceived) {
        String content = "PELÍCULA " + idReceived + "." + position;

        return new PeliculaItemCatalog(
                position, content, fetchPeliculaDetails(position,idReceived)
        );

    }


    private String fetchPeliculaDetails(int position, int idReceived) {
        String content = "Película " + idReceived + "." + position;
        StringBuilder builder = new StringBuilder();
        builder.append(content);

       /* for (int index = 0; index < position; index++) {
            builder.append("\nMore details information here.");
        }

        */

        return builder.toString();
    }

}

