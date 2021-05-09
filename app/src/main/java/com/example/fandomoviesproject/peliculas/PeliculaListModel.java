package com.example.fandomoviesproject.peliculas;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.example.fandomoviesproject.data.PeliculaItem;
//import com.example.recyclerview.data.RepositoryContract;

public class PeliculaListModel implements PeliculaListContract.Model {

    public static String TAG = PeliculaListModel.class.getSimpleName();

    private final List<PeliculaItem> itemList = new ArrayList<>();
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
    public List<PeliculaItem> fetchPeliculaListData() {
        Log.e(TAG, "fetchPeliculaListData()");
        return itemList;
    }

    private void addProduct(PeliculaItem item) {
        itemList.add(item);
    }


    private PeliculaItem createProduct(int position, int idReceived) {
        String content = "PELÍCULA " + idReceived + "." + position;

        return new PeliculaItem(
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

