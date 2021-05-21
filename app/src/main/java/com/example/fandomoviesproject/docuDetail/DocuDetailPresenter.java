package com.example.fandomoviesproject.docuDetail;


import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.DocuItemCatalog;
import java.lang.ref.WeakReference;

public class DocuDetailPresenter implements DocuDetailContract.Presenter {

    public static String TAG = DocuDetailPresenter.class.getSimpleName();

    private WeakReference<DocuDetailContract.View> view;
    private DocuDetailState state;
    private DocuDetailContract.Model model;
    private AppMediator mediator;

    public DocuDetailPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getDocuDetailState();
    }


    @Override
    public void injectView(WeakReference<DocuDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(DocuDetailContract.Model model) {
        this.model = model;
    }


    private DocuItemCatalog getDataFromDocuListScreen() {
        DocuItemCatalog product = mediator.getProduct2Docu();
        return product;
    }

    @Override
    public void onClickTrailerButton(){
        view.get().navigateToURLtrailer(state.url_trailer);
    }


    @Override
    public void fetchDocuDetailData() {
        // Log.e(TAG, "fetchProductDetailData()");

        // set passed state
        DocuItemCatalog serie = getDataFromDocuListScreen();
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

        view.get().displayDocuDetailData(state);
    }

}
