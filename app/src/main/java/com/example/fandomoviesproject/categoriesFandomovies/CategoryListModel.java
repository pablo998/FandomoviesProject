package com.example.fandomoviesproject.categoriesFandomovies;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.example.fandomoviesproject.data.CategoryItem;
//TODO descomentar
//import com.example.recyclerview.data.RepositoryContract;

public class CategoryListModel implements CategoryListContract.Model {

    public static String TAG = CategoryListModel.class.getSimpleName();

    private final List<CategoryItem> itemList = new ArrayList<>();
    private final int COUNT = 20;

    // TODO DE AQUI HASTA ABAJO QUEDA PENDIENTE HASTA QUE SE IMPLEMENTE EL REPOSITORIO

    /*
    private RepositoryContract repository;

    public CategoryListModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void fetchCategoryListData(
            final RepositoryContract.GetCategoryListCallback callback) {

        Log.e(TAG, "fetchCategoryListData()");

        repository.loadCatalog(new RepositoryContract.FetchCatalogDataCallback() {

            @Override
            public void onCatalogDataFetched(boolean error) {
                if(!error) {
                    repository.getCategoryList(callback);
                }
            }
        });

    }

     */

    public CategoryListModel() {
        // Add some sample items
        for (int index = 1; index <= COUNT; index++) {
            addProduct(createProduct(index));
        }
    }

    @Override
    public List<CategoryItem> fetchCategoryListData() {
        Log.e(TAG, "fetchCategoryListData()");
        return itemList;
    }

    private void addProduct(CategoryItem item) {
        itemList.add(item);
    }


    private CategoryItem createProduct(int position) {
        String content = "CATEGORÍA " + position;

        return new CategoryItem(
                position, content
        );

    }

}

