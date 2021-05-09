package com.example.fandomoviesproject.seriesDeUnaCategoria;

import com.example.fandomoviesproject.data.SerieItemCatalog;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListViewModel;

import java.lang.ref.WeakReference;
import java.util.List;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

interface SerieListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displaySerieListData(SerieListViewModel viewModel);

        void navigateToSerieDetailScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        void fetchSerieListData();
        void selectSerieListData(SerieItemCatalog item);

        int getIdReceived();
        //TODO para cuando haya repo descomentar
        //String getCategoriaElegida();
    }

    interface Model {
        List<SerieItemCatalog> fetchSerieListData();
        //TODO. QUEDA PENDIENTE
        /*
        void fetchSerieListData(
                RepositoryContract.GetSerieListCallback callback);

         */

        void createItemList (int idReceived);
    }

}
