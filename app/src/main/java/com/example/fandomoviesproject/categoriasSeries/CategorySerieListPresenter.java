package com.example.fandomoviesproject.categoriasSeries;

import android.util.Log;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;

import java.lang.ref.WeakReference;
import java.util.List;


import com.example.fandomoviesproject.data.RepositoryContract;


public class CategorySerieListPresenter implements CategorySerieListContract.Presenter {

    public static String TAG = CategorySerieListPresenter.class.getSimpleName();

    private WeakReference<CategorySerieListContract.View> view;
    private CategorySerieListState state;
    private CategorySerieListContract.Model model;
    private AppMediator mediator;

    public CategorySerieListPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getCategorySerieListState();
    }

    @Override
    public void injectView(WeakReference<CategorySerieListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CategorySerieListContract.Model model) {
        this.model = model;
    }

    private void passDataToSerieScreen(CategorySerieItemCatalog item) {
        mediator.setCategoriaInSerieListScreen(item);
    }


    @Override
    public void fetchCategorySerieListData() {
        // Log.e(TAG, "fetchCategorySerieListData()");

        // call the model
        model.fetchCategorySerieListData(new RepositoryContract.GetCategorySerieListCallback() {

            @Override
            public void setCategorySerieList(List<CategorySerieItemCatalog> categories) {
                state.categories = categories;

                view.get().displayCategorySerieListData(state);
            }
        });

    }

    @Override
    public void selectCategorySerieListData(CategorySerieItemCatalog item) {
        passDataToSerieScreen(item);
        view.get().navigateToProductScreen();
    }


}
