package com.example.fandomoviesproject.peliculas;

import android.util.Log;

import java.lang.ref.WeakReference;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.PeliculaItem;


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


    @Override
    public int getIdReceived(){
        int idReceived = mediator.getProduct1().id;
        return idReceived;
    }
/*
    @Override
    public String getCategoriaElegida(){
        String categoriaElegida = mediator.getProduct1().content;
        return categoriaElegida;
    }

 */

    private void passDataToPeliculaDetailScreen(PeliculaItem item) {
        mediator.setPeliculaInPeliculaDetailScreen(item);
    }

    @Override
    public void fetchPeliculaListData() {
        Log.e(TAG, "fetchPeliculaListData()");

        int idReceived = getIdReceived();
        if(idReceived != 0) {
            model.createItemList(idReceived);

            //Call the model
            state.products = model.fetchPeliculaListData();
        }
        view.get().displayPeliculaListData(state);

    }


    @Override
    public void selectPeliculaListData(PeliculaItem item) {
        passDataToPeliculaDetailScreen(item);
        view.get().navigateToPeliculaDetailScreen();
    }


}
