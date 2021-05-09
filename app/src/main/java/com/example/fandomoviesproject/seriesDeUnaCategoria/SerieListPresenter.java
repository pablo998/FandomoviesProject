package com.example.fandomoviesproject.seriesDeUnaCategoria;

import android.util.Log;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.SerieItemCatalog;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListContract;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListState;

import java.lang.ref.WeakReference;


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


    @Override
    public int getIdReceived(){
        int idReceived = mediator.getProduct1Serie().id;
        return idReceived;
    }
/*
    @Override
    public String getCategoriaElegida(){
        String categoriaElegida = mediator.getProduct1Serie().content;
        return categoriaElegida;
    }

 */

    private void passDataToSerieDetailScreen(SerieItemCatalog item) {
        mediator.setSerieInSerieDetailScreen(item);
    }

    @Override
    public void fetchSerieListData() {
        Log.e(TAG, "fetchSerieListData()");

        int idReceived = getIdReceived();
        if(idReceived != 0) {
            model.createItemList(idReceived);

            //Call the model
            state.products = model.fetchSerieListData();
        }
        view.get().displaySerieListData(state);

    }


    @Override
    public void selectSerieListData(SerieItemCatalog item) {
        passDataToSerieDetailScreen(item);
        view.get().navigateToSerieDetailScreen();
    }


}
