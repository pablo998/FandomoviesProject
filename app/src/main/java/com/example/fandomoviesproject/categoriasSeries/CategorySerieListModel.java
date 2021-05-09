package com.example.fandomoviesproject.categoriasSeries;

import android.util.Log;

import com.example.fandomoviesproject.data.CategorySerieItemCatalog;

import java.util.ArrayList;
import java.util.List;
//TODO descomentar
//import com.example.recyclerview.data.RepositoryContract;

public class CategorySerieListModel implements CategorySerieListContract.Model {

    public static String TAG = CategorySerieListModel.class.getSimpleName();

    private final List<CategorySerieItemCatalog> itemList = new ArrayList<>();
    private final int COUNT = 20;

    // TODO DE AQUI HASTA ABAJO QUEDA PENDIENTE HASTA QUE SE IMPLEMENTE EL REPOSITORIO

    /*
    private RepositoryContract repository;

    public CategoryListModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void fetchCategorySerieListData(
            final RepositoryContract.GetCategoryListCallback callback) {

        Log.e(TAG, "fetchCategorySerieListData()");

        repository.loadCatalog(new RepositoryContract.FetchCatalogDataCallback() {

            @Override
            public void onCatalogDataFetched(boolean error) {
                if(!error) {
                    repository.getCategorySerieList(callback);
                }
            }
        });

    }

     */

    public CategorySerieListModel() {
        // Add some sample items
        for (int index = 1; index <= COUNT; index++) {
            addProduct(createProduct(index));
        }
    }

    @Override
    public List<CategorySerieItemCatalog> fetchCategorySerieListData() {
        Log.e(TAG, "fetchCategoryListData()");
        return itemList;
    }

    private void addProduct(CategorySerieItemCatalog item) {
        itemList.add(item);
    }


    private CategorySerieItemCatalog createProduct(int position) {
        String content = "CATEGORÍA " + position;

        return new CategorySerieItemCatalog(
                position, content
        );

    }

}

