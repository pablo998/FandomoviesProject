package com.example.fandomoviesproject.docusDeUnaCategoria;

import com.example.fandomoviesproject.data.DocuItemCatalog;
import com.example.fandomoviesproject.data.SerieItemCatalog;

import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListViewModel;

import java.lang.ref.WeakReference;
import java.util.List;

public interface DocuListContract {

    interface View{

        void injectPresenter(DocuListContract.Presenter presenter);

        void displayDocuListData(DocuListViewModel viewModel);

        void navigateToDocuDetailScreen();
    }

    interface Presenter{
        void injectView(WeakReference<DocuListContract.View> view);
        void injectModel(DocuListContract.Model model);
        void fetchDocuListData();
        void selectDocuListData(DocuItemCatalog item);

        int getIdReceived();
        //TODO para cuando haya repo descomentar
        //String getCategoriaElegida();


    }

    interface Model{
        List<DocuItemCatalog> fetchDocuListData();
        //TODO. QUEDA PENDIENTE
        /*
        void fetchSerieListData(
                RepositoryContract.GetSerieListCallback callback);

         */

        void createItemList (int idReceived);
    }
}
