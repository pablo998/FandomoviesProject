package com.example.fandomoviesproject.categoriasPelis;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;
import com.example.fandomoviesproject.data.RepositoryContract;

//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


public class CategoryListPresenter implements CategoryListContract.Presenter {

    public static String TAG = CategoryListPresenter.class.getSimpleName();

    private WeakReference<CategoryListContract.View> view;
    private CategoryListState state;
    private CategoryListContract.Model model;
    private AppMediator mediator;

    public CategoryListPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getCategoryListState();
    }

    @Override
    public void injectView(WeakReference<CategoryListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CategoryListContract.Model model) {
        this.model = model;
    }

    private void passDataToPeliculaScreen(CategoryItemCatalog item) {
        mediator.setCategoriaInPeliculaListScreen(item);
    }

    @Override
    public void fetchCategoryListData() {
        // Log.e(TAG, "fetchCategoryPeliListData()");

        // call the model
        model.fetchCategoryListData(new RepositoryContract.GetCategoryPeliListCallback() {

            @Override
            public void setCategoryPeliList(List<CategoryItemCatalog> categories) {
                state.categories = categories;

                view.get().displayCategoryListData(state);
            }
        });

    }

    @Override
    public void selectCategoryListData(CategoryItemCatalog item) {
        passDataToPeliculaScreen(item);
        view.get().navigateToProductScreen();
    }


}
