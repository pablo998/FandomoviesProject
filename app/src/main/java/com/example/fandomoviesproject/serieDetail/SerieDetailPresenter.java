package com.example.fandomoviesproject.serieDetail;

import android.util.Log;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.SerieItemCatalog;
import com.example.fandomoviesproject.serieDetail.SerieDetailContract;
import com.example.fandomoviesproject.serieDetail.SerieDetailState;

import java.lang.ref.WeakReference;


public class SerieDetailPresenter implements SerieDetailContract.Presenter {

    public static String TAG = SerieDetailPresenter.class.getSimpleName();

    private WeakReference<SerieDetailContract.View> view;
    private SerieDetailState state;
    private SerieDetailContract.Model model;
    private AppMediator mediator;

    public SerieDetailPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getSerieDetailState();
    }

//  public ProductDetailPresenter(ProductDetailState state) {
//    this.state = state;
//  }

    @Override
    public void injectView(WeakReference<SerieDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(SerieDetailContract.Model model) {
        this.model = model;
    }


    private SerieItemCatalog getDataFromSerieListScreen() {
        SerieItemCatalog product = mediator.getProduct2Serie();
        return product;
    }

    @Override
    public void onClickTrailerButton(){
        view.get().navigateToURLtrailer(state.url_trailer);
    }

    @Override
    public void fetchSerieDetailData() {
        // Log.e(TAG, "fetchProductDetailData()");

        // set passed state
        SerieItemCatalog serie = getDataFromSerieListScreen();
        if(serie != null) {
            state.product = serie;
            state.content = serie.content;
            state.fecha = serie.fecha;
            state.url_trailer = serie.url_trailer;
            state.url_imagen = serie.url_imagen;
            state.sinopsis = serie.sinopsis;
            state.actor1 = serie.actor1;
            state.actor2 = serie.actor2;
            state.actor3 = serie.actor3;
            state.valoracion1 = serie.valoracion1;
            state.valoracion2 = serie.valoracion2;
            state.valoracion3 = serie.valoracion3;

        }

        view.get().displaySerieDetailData(state);
    }

}

