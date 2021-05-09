package com.example.fandomoviesproject.categoriasSeries;

import android.util.Log;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;

import java.lang.ref.WeakReference;

//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


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
    public void fetchCategoryListData() {
        Log.e(TAG, "fetchCategoryListData()");

        // call the model
        state.products = model.fetchCategorySerieListData();

        view.get().displayCategorySerieListData(state);

    }

    //TODO ESTA METODO QUEDA PENDIENTE PARA CUANO SE IMPLEMENTE EL REPOSITORIO
    /*
    @Override
    public void fetchCategoryListData() {
        // Log.e(TAG, "fetchCategoryListData()");

        // call the model
        model.fetchCategoryListData(new RepositoryContract.GetCategoryListCallback() {

            @Override
            public void setCategoryList(List<CategoryItemCatalog> categories) {
                state.categories = categories;

                view.get().displayCategoryListData(state);
            }
        });

    }

     */

    @Override
    public void selectCategoryListData(CategorySerieItemCatalog item) {
        passDataToSerieScreen(item);
        view.get().navigateToProductScreen();
    }


}
