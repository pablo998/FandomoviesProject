package com.example.fandomoviesproject.categoriesFandomovies;

import android.util.Log;

import java.lang.ref.WeakReference;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.CategoryItem;

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

    private void passDataToPeliculaScreen(CategoryItem item) {
        mediator.setPeliculaInPeliculaListScreen(item);
    }

    @Override
    public void fetchCategoryListData() {
        Log.e(TAG, "fetchCategoryListData()");

        // call the model
        state.products = model.fetchCategoryListData();

        view.get().displayCategoryListData(state);

    }

    //TODO ESTA METODO QUEDA PENDIENTE PARA CUANO SE IMPLEMENTE EL REPOSITORIO
    /*
    @Override
    public void fetchCategoryListData() {
        // Log.e(TAG, "fetchCategoryListData()");

        // call the model
        model.fetchCategoryListData(new RepositoryContract.GetCategoryListCallback() {

            @Override
            public void setCategoryList(List<CategoryItem> categories) {
                state.categories = categories;

                view.get().displayCategoryListData(state);
            }
        });

    }

     */

    @Override
    public void selectCategoryListData(CategoryItem item) {
        passDataToPeliculaScreen(item);
        view.get().navigateToProductScreen();
    }


}
