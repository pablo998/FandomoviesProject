package com.example.fandomoviesproject.peliculas;

import java.lang.ref.WeakReference;
import java.util.List;

import com.example.fandomoviesproject.data.PeliculaItem;
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
        void selectPeliculaListData(PeliculaItem item);

        int getIdReceived();
        //TODO para cuando haya repo descomentar
        //String getCategoriaElegida();
    }

    interface Model {
        List<PeliculaItem> fetchPeliculaListData();
        //TODO. QUEDA PENDIENTE
        /*
        void fetchPeliculaListData(
                RepositoryContract.GetPeliculaListCallback callback);

         */

        void createItemList (int idReceived);
    }

}
