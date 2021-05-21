package com.example.fandomoviesproject.categoriasDocu;


import com.example.fandomoviesproject.categoriasSeries.CategorySerieListViewModel;
import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;
import com.example.fandomoviesproject.data.Repository;

import java.lang.ref.WeakReference;
import java.util.List;

public interface CategoryDocuListContract {

    interface View{
        void injectPresenter(CategoryDocuListContract.Presenter presenter);

        void displayCategoryDocuListData(CategoryDocuListViewModel viewModel);

        void navigateToProductDocuScreen();
    }

    interface Presenter{

        void injectView(WeakReference<CategoryDocuListContract.View> view);

        void injectModel(CategoryDocuListContract.Model model);

        void fetchCategoryDocuListData();

        void selectCategoryDocuListData(CategoryDocuItemCatalog item);
    }

    interface Model{
        void fetchCategoryDocuListData(
                Repository.GetCategoryDocuListCallback callback);
    }
}
