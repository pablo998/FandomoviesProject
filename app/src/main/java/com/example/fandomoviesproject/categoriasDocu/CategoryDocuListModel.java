package com.example.fandomoviesproject.categoriasDocu;

import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;

import java.util.ArrayList;
import java.util.List;

public class CategoryDocuListModel implements CategoryDocuListContract.Model {

    public static String TAG = CategoryDocuListModel.class.getSimpleName();

    private final List<CategoryDocuItemCatalog> itemList = new ArrayList<>();
    private final int COUNT = 20;



    public CategoryDocuListModel() {
        for (int index = 1; index <= COUNT; index++) {
            addProduct(createProduct(index));
        }
    }

    private void addProduct(CategoryDocuItemCatalog item) {
        itemList.add(item);
    }

    @Override
    public List<CategoryDocuItemCatalog> fetchCategoryDocuListData() {
        return itemList;
    }

    private CategoryDocuItemCatalog createProduct(int position) {
        String content = "CATEGORÍA " + position;

        return new CategoryDocuItemCatalog(
                position, content
        );

    }
}