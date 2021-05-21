package com.example.fandomoviesproject.peliculasDeUnaCategoria;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;
import com.example.fandomoviesproject.data.RepositoryContract;
import com.example.fandomoviesproject.data.SerieItemCatalog;


public class PeliculaListPresenter implements PeliculaListContract.Presenter {

    public static String TAG = PeliculaListPresenter.class.getSimpleName();

    private WeakReference<PeliculaListContract.View> view;
    private PeliculaListState state;
    private PeliculaListContract.Model model;
    //private ProductListContract.Router router;
    private AppMediator mediator;


    public PeliculaListPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getPeliculaListState();
    }

//  public ProductListPresenter(ProductListState state) {
//    this.state = state;
//  }

    @Override
    public void injectView(WeakReference<PeliculaListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(PeliculaListContract.Model model) {
        this.model = model;
    }


    private void passDataToPeliculaDetailScreen(PeliculaItemCatalog item) {
        mediator.setPeliculaInPeliculaDetailScreen(item);
    }


    @Override
    public void fetchPeliculaListData() {
        // Log.e(TAG, "fetchPeliculaListData()");

        // set passed state
        CategoryItemCatalog category = getDataFromCategoryPelisListScreen();

        if (category != null) {
            state.category = category;
        }

        // call the model
        model.fetchPeliculaListData(state.category,
                new RepositoryContract.GetPelisListCallback() {

                    @Override
                    public void setPelisList(List<PeliculaItemCatalog> products) {
                        state.products = products;

                        view.get().displayPeliculaListData(state);
                    }
                });
    }


    @Override
    public void selectPeliculaListData(PeliculaItemCatalog item) {
        passDataToPeliculaDetailScreen(item);
        view.get().navigateToPeliculaDetailScreen();
    }

    private CategoryItemCatalog getDataFromCategoryPelisListScreen() {
        CategoryItemCatalog category = mediator.getProduct1();
        return category;
    }


}
