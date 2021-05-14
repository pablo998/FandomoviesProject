package com.example.fandomoviesproject.categoriasDocu;


import com.example.fandomoviesproject.categoriasSeries.CategorySerieListViewModel;
import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;

import java.lang.ref.WeakReference;
import java.util.List;

public interface CategoryDocuListContract {

    interface View{
        void injectPresenter(CategoryDocuListContract.Presenter presenter);

        void displayCategoryDocuListData(CategoryDocuListViewModel viewModel);

        void navigateToProductScreen();
    }

    interface Presenter{

        void injectView(WeakReference<CategoryDocuListContract.View> view);

        void injectModel(CategoryDocuListContract.Model model);

        void fetchCategoryListData();

        void selectCategoryListData(CategoryDocuItemCatalog item);
    }

    interface Model{
        List<CategoryDocuItemCatalog> fetchCategoryDocuListData();
        //TODO. QUEDA PENDIENTE
    }
}
