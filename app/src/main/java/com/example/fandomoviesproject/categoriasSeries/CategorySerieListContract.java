package com.example.fandomoviesproject.categoriasSeries;

import com.example.fandomoviesproject.data.CategorySerieItemCatalog;

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

        void fetchCategoryListData();

        void selectCategoryListData(CategorySerieItemCatalog item);
    }

    interface Model {
        List<CategorySerieItemCatalog> fetchCategorySerieListData();
        //TODO. QUEDA PENDIENTE
        /*
        void fetchCategorySerieListData(
                RepositoryContract.GetCategoryListCallback callback);

         */
    }
}