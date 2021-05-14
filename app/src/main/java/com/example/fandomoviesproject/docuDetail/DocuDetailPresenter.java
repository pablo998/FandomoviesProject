package com.example.fandomoviesproject.docuDetail;

import android.util.Log;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.DocuItemCatalog;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;
import com.example.fandomoviesproject.data.SerieItemCatalog;

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

    @Override
    public String getDocuName(){
        int espacio = mediator.getProduct2Docu().content.indexOf(" ");
        return mediator.getProduct2Docu().content.substring(espacio);
    }

    private DocuItemCatalog getDataFromDocuListScreen() {
        DocuItemCatalog product = mediator.getProduct2Docu();
        return product;
    }

    @Override
    public void fetchDocuDetailData() {
        Log.e(TAG, "fetchSerieDetailData()");

        // set passed state
        DocuItemCatalog product = getDataFromDocuListScreen();
        if (product != null) {
            state.product = product;
            //Call the model
            //TODO para cuando haya repo
            // state.product = model.fetchSerieDetailData();
        }

        view.get().displayDocuDetailData(state);
    }

}
