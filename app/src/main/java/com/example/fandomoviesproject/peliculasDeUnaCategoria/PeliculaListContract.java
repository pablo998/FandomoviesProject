package com.example.fandomoviesproject.peliculasDeUnaCategoria;

import java.lang.ref.WeakReference;
import java.util.List;

import com.example.fandomoviesproject.data.PeliculaItemCatalog;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

interface PeliculaListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayPeliculaListData(PeliculaListViewModel viewModel);

        void navigateToPeliculaDetailScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        void fetchPeliculaListData();
        void selectPeliculaListData(PeliculaItemCatalog item);

        int getIdReceived();
        //TODO para cuando haya repo descomentar
        //String getCategoriaElegida();
    }

    interface Model {
        List<PeliculaItemCatalog> fetchPeliculaListData();
        //TODO. QUEDA PENDIENTE
        /*
        void fetchPeliculaListData(
                RepositoryContract.GetPeliculaListCallback callback);

         */

        void createItemList (int idReceived);
    }

}
