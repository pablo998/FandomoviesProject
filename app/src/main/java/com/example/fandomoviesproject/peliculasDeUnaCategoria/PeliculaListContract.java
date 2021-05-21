package com.example.fandomoviesproject.peliculasDeUnaCategoria;

import java.lang.ref.WeakReference;
import java.util.List;

import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;
import com.example.fandomoviesproject.data.RepositoryContract;
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
    }

    interface Model {
        void fetchPeliculaListData(
                CategoryItemCatalog category, RepositoryContract.GetPelisListCallback callback);
    }

}
