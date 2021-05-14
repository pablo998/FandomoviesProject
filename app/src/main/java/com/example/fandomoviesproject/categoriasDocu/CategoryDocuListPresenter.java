package com.example.fandomoviesproject.categoriasDocu;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;

import java.lang.ref.WeakReference;

public class CategoryDocuListPresenter implements CategoryDocuListContract.Presenter {

    public static String TAG = CategoryDocuListPresenter.class.getSimpleName();

    private WeakReference<CategoryDocuListContract.View> view;
    private CategoryDocuListState state;
    private CategoryDocuListContract.Model model;
    private AppMediator mediator;

    public CategoryDocuListPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getCategoryDocuListState();
    }



    @Override
    public void injectView(WeakReference<CategoryDocuListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CategoryDocuListContract.Model model) {
        this.model = model;
    }

    private void passDataToDocuScreen(CategoryDocuItemCatalog item) {
        mediator.setCategoriaInDocuListScreen(item);
    }

    @Override
    public void fetchCategoryListData() {

        // call the model
        state.products = model.fetchCategoryDocuListData();

        view.get().displayCategoryDocuListData(state);

    }

    @Override
    public void selectCategoryListData(CategoryDocuItemCatalog item) {
        passDataToDocuScreen(item);
        view.get().navigateToProductScreen();

    }

}
