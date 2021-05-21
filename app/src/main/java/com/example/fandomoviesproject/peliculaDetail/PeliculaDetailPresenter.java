package com.example.fandomoviesproject.peliculaDetail;

import java.lang.ref.WeakReference;
import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;

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


    private PeliculaItemCatalog getDataFromPeliculaListScreen() {
        PeliculaItemCatalog product = mediator.getProduct2();
        return product;
    }

    @Override
    public void onClickTrailerButton(){
        view.get().navigateToURLtrailer(state.url_trailer);
    }

    @Override
    public void fetchPeliculaDetailData() {
        // Log.e(TAG, "fetchProductDetailData()");

        // set passed state
        PeliculaItemCatalog serie = getDataFromPeliculaListScreen();
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

        view.get().displayPeliculaDetailData(state);
    }

}

