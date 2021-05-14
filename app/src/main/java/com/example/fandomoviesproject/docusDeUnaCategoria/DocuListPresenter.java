package com.example.fandomoviesproject.docusDeUnaCategoria;

import android.util.Log;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.DocuItemCatalog;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;


import java.lang.ref.WeakReference;

public class DocuListPresenter implements DocuListContract.Presenter {

    public static String TAG = DocuListPresenter.class.getSimpleName();

    private WeakReference<DocuListContract.View> view;
    private DocuListState state;
    private DocuListContract.Model model;
    private AppMediator mediator;

    public DocuListPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getDocuListState();
    }



    @Override
    public void injectView(WeakReference<DocuListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(DocuListContract.Model model) {
        this.model = model;
    }

    @Override
    public int getIdReceived(){
        int idReceived = mediator.getProduct1Docu().id;
        return idReceived;
    }

    private void passDataToDocuDetailScreen(DocuItemCatalog item) {
        mediator.setDocuInDocuDetailScreen(item);
    }

    @Override
    public void fetchDocuListData() {
        Log.e(TAG, "fetchDocuListData()");

        int idReceived = getIdReceived();
        if(idReceived != 0) {
            model.createItemList(idReceived);

            //Call the model
            state.products = model.fetchDocuListData();
        }
        view.get().displayDocuListData(state);

    }

    @Override
    public void selectDocuListData(DocuItemCatalog item) {
        passDataToDocuDetailScreen(item);
        view.get().navigateToDocuDetailScreen();
    }



}
