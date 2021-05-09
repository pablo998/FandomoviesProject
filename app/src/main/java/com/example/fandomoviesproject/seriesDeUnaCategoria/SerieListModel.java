package com.example.fandomoviesproject.seriesDeUnaCategoria;

import android.util.Log;

import com.example.fandomoviesproject.data.SerieItemCatalog;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListContract;

import java.util.ArrayList;
import java.util.List;
//import com.example.recyclerview.data.RepositoryContract;

public class SerieListModel implements SerieListContract.Model {

    public static String TAG = SerieListModel.class.getSimpleName();

    private final List<SerieItemCatalog> itemList = new ArrayList<>();
    private final int COUNT = 20;

    public SerieListModel(){

    }

    // TODO DE AQUI HASTA ABAJO QUEDA PENDIENTE HASTA QUE SE IMPLEMENTE EL REPOSITORIO

    /*
    private RepositoryContract repository;

    public SerieListModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void fetchSerieListData(
            final RepositoryContract.GetSerieListCallback callback) {

        Log.e(TAG, "fetchSerieListData()");

        repository.loadCatalog(new RepositoryContract.FetchCatalogDataCallback() {

            @Override
            public void onCatalogDataFetched(boolean error) {
                if(!error) {
                    repository.getSerieList(callback);
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
    public List<SerieItemCatalog> fetchSerieListData() {
        Log.e(TAG, "fetchSerieListData()");
        return itemList;
    }

    private void addProduct(SerieItemCatalog item) {
        itemList.add(item);
    }


    private SerieItemCatalog createProduct(int position, int idReceived) {
        String content = "SERIE " + idReceived + "." + position;

        return new SerieItemCatalog(
                position, content, fetchSerieDetails(position,idReceived)
        );

    }


    private String fetchSerieDetails(int position, int idReceived) {
        String content = "Serie " + idReceived + "." + position;
        StringBuilder builder = new StringBuilder();
        builder.append(content);

       /* for (int index = 0; index < position; index++) {
            builder.append("\nMore details information here.");
        }

        */

        return builder.toString();
    }

}

