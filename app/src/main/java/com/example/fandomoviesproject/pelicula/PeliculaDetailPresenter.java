package com.example.fandomoviesproject.pelicula;

import android.util.Log;

import java.lang.ref.WeakReference;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.PeliculaItem;


public class PeliculaDetailPresenter implements PeliculaDetailContract.Presenter {

    public static String TAG = PeliculaDetailPresenter.class.getSimpleName();

    private WeakReference<PeliculaDetailContract.View> view;
    private PeliculaDetailState state;
    private PeliculaDetailContract.Model model;
    private AppMediator mediator;

    public PeliculaDetailPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getPeliculaDetailState();
    }

//  public ProductDetailPresenter(ProductDetailState state) {
//    this.state = state;
//  }

    @Override
    public void injectView(WeakReference<PeliculaDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(PeliculaDetailContract.Model model) {
        this.model = model;
    }


    @Override
    public String getPeliculaName(){
        int espacio = mediator.getProduct2().content.indexOf(" ");
        return mediator.getProduct2().content.substring(espacio);
    }


    /*@Override
    public String getPeliculaNameConRepo(){
        String nombrePeli = mediator.getProduct2().content;
        return nombrePeli;
    }

     */

    private PeliculaItem getDataFromPeliculaListScreen() {
        PeliculaItem product = mediator.getProduct2();
        return product;
    }

    @Override
    public void fetchPeliculaDetailData() {
        Log.e(TAG, "fetchPeliculaDetailData()");

        // set passed state
        PeliculaItem product = getDataFromPeliculaListScreen();
        if (product != null) {
            state.product = product;
            //Call the model
            //TODO para cuando haya repo
           // state.product = model.fetchPeliculaDetailData();
        }

        view.get().displayPeliculaDetailData(state);
    }

}

