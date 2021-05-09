package com.example.fandomoviesproject.categoriesFandomovies;

import java.lang.ref.WeakReference;
import java.util.List;

import com.example.fandomoviesproject.data.CategoryItem;

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

        void selectCategoryListData(CategoryItem item);
    }

    interface Model {
        List<CategoryItem> fetchCategoryListData();
        //TODO. QUEDA PENDIENTE
        /*
        void fetchCategoryListData(
                RepositoryContract.GetCategoryListCallback callback);

         */
    }
}