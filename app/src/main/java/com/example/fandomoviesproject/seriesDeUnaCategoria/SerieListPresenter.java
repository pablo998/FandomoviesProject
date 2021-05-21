package com.example.fandomoviesproject.seriesDeUnaCategoria;

import android.util.Log;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;
import com.example.fandomoviesproject.data.RepositoryContract;
import com.example.fandomoviesproject.data.SerieItemCatalog;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListContract;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListState;

import java.lang.ref.WeakReference;
import java.util.List;


public class SerieListPresenter implements SerieListContract.Presenter {

    public static String TAG = SerieListPresenter.class.getSimpleName();

    private WeakReference<SerieListContract.View> view;
    private SerieListState state;
    private SerieListContract.Model model;
    private AppMediator mediator;


    public SerieListPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getSerieListState();
    }

//  public ProductListPresenter(ProductListState state) {
//    this.state = state;
//  }

    @Override
    public void injectView(WeakReference<SerieListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(SerieListContract.Model model) {
        this.model = model;
    }



    private void passDataToSerieDetailScreen(SerieItemCatalog item) {
        mediator.setSerieInSerieDetailScreen(item);
    }

    @Override
    public void fetchSerieListData() {
        // Log.e(TAG, "fetchSeriesListData()");

        // set passed state
        CategorySerieItemCatalog category = getDataFromCategorySeriesListScreen();

        if (category != null) {
            state.category = category;
        }

        // call the model
        model.fetchSerieListData(state.category,
                new RepositoryContract.GetSeriesListCallback() {

                    @Override
                    public void setSeriesList(List<SerieItemCatalog> products) {
                        state.products = products;

                        view.get().displaySerieListData(state);
                    }
                });
    }


    @Override
    public void selectSerieListData(SerieItemCatalog item) {
        passDataToSerieDetailScreen(item);
        view.get().navigateToSerieDetailScreen();
    }

    private CategorySerieItemCatalog getDataFromCategorySeriesListScreen() {
        CategorySerieItemCatalog category = mediator.getProduct1Serie();
        return category;
    }


}
