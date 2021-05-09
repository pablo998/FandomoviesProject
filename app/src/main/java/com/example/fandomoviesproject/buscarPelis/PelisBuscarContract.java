package com.example.fandomoviesproject.buscarPelis;

import com.example.fandomoviesproject.data.PeliculaItem;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

interface PelisBuscarContract {

    interface View {

        void injectPresenter(Presenter presenter);
        void displayPelisBuscarData(PelisBuscarViewModel viewModel);

        void navigateToBuscarSeriesActivity();
        void navigateToBuscarDocusActivity();
        void changeCorazonColor();
        void goToPaginaWeb();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

       //TODO descomentar linea de abajo cuando repo este hecho y se haya implementado el metodo
        //void fetchPelisBuscarData();
        void navigateToBuscarSeriesActivity();
        void navigateToBuscarDocusActivity();

        void clickLike(PeliculaItem peli);
        void clickComprar(PeliculaItem peli);
    }

    interface Model {

        //TODO ESTO QUEDA PENDIENTE
        /*
        void fetchPelisBuscarData(
                RepositoryContract.GetCategoryListCallback callback);

         */
    }


}