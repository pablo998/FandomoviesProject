package com.example.fandomoviesproject.buscarSeries;

import com.example.fandomoviesproject.data.SerieItem;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

interface SeriesBuscarContract {

    interface View {

        void injectPresenter(Presenter presenter);
        void displaySeriesBuscarData(SeriesBuscarViewModel viewModel);

        void navigateToBuscarPelisActivity();
        void navigateToBuscarDocusActivity();
        void changeCorazonColor();
        void goToPaginaWeb();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        //TODO descomentar linea de abajo cuando repo este hecho y se haya implementado el metodo
        //void fetchSeriesBuscarData();
        void navigateToBuscarPelisActivity();
        void navigateToBuscarDocusActivity();

        void clickLike(SerieItem serie);
        void clickComprar(SerieItem serie);
    }

    interface Model {

        //TODO ESTO QUEDA PENDIENTE
        /*
        void fetchSeriesBuscarData(
                RepositoryContract.GetCategoryListCallback callback);

         */
    }


}
