package com.example.fandomoviesproject.docusDeUnaCategoria;

import android.util.Log;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;
import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.data.DocuItemCatalog;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;
import com.example.fandomoviesproject.data.RepositoryContract;


import java.lang.ref.WeakReference;
import java.util.List;

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


    private void passDataToDocuDetailScreen(DocuItemCatalog item) {
        mediator.setDocuInDocuDetailScreen(item);
    }

    @Override
    public void fetchDocuListData() {
        // Log.e(TAG, "fetchDocuListData()");

        // set passed state
        CategoryDocuItemCatalog category = getDataFromCategoryDocuListScreen();

        if (category != null) {
            state.category = category;
        }

        // call the model
        model.fetchDocuListData(state.category,
                new RepositoryContract.GetDocusListCallback() {

                    @Override
                    public void setDocusList(List<DocuItemCatalog> products) {
                        state.products = products;

                        view.get().displayDocuListData(state);
                    }
                });
    }

    @Override
    public void selectDocuListData(DocuItemCatalog item) {
        passDataToDocuDetailScreen(item);
        view.get().navigateToDocuDetailScreen();
    }


    private CategoryDocuItemCatalog getDataFromCategoryDocuListScreen() {
        CategoryDocuItemCatalog category = mediator.getProduct1Docu();
        return category;
    }



}
