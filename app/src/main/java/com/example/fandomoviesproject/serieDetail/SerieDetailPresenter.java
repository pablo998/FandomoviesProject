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


    @Override
    public String getSerieName(){
        int espacio = mediator.getProduct2Serie().content.indexOf(" ");
        return mediator.getProduct2Serie().content.substring(espacio);
    }


    /*@Override
    public String getSerieNameConRepo(){
        String nombreSerie = mediator.getProduct2Serie().content;
        return nombreSerie;
    }

     */

    private SerieItemCatalog getDataFromSerieListScreen() {
        SerieItemCatalog product = mediator.getProduct2Serie();
        return product;
    }

    @Override
    public void fetchSerieDetailData() {
        Log.e(TAG, "fetchSerieDetailData()");

        // set passed state
        SerieItemCatalog product = getDataFromSerieListScreen();
        if (product != null) {
            state.product = product;
            //Call the model
            //TODO para cuando haya repo
           // state.product = model.fetchSerieDetailData();
        }

        view.get().displaySerieDetailData(state);
    }

}

