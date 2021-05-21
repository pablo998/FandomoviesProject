package com.example.fandomoviesproject.categoriasSeries;

import com.example.fandomoviesproject.data.CategorySerieItemCatalog;
import com.example.fandomoviesproject.data.Repository;

import java.lang.ref.WeakReference;
import java.util.List;

//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


interface CategorySerieListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayCategorySerieListData(CategorySerieListViewModel viewModel);

        void navigateToProductScreen();

    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void fetchCategorySerieListData();

        void selectCategorySerieListData(CategorySerieItemCatalog item);
    }

    interface Model {
        void fetchCategorySerieListData(
                Repository.GetCategorySerieListCallback callback);
    }
}