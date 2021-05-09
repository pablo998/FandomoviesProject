package com.example.fandomoviesproject.categoriasPelis;

import java.lang.ref.WeakReference;
import java.util.List;

import com.example.fandomoviesproject.data.CategoryItemCatalog;

//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


interface CategoryListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayCategoryListData(CategoryListViewModel viewModel);

        void navigateToProductScreen();

    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void fetchCategoryListData();

        void selectCategoryListData(CategoryItemCatalog item);
    }

    interface Model {
        List<CategoryItemCatalog> fetchCategoryListData();
        //TODO. QUEDA PENDIENTE
        /*
        void fetchCategoryListData(
                RepositoryContract.GetCategoryListCallback callback);

         */
    }
}