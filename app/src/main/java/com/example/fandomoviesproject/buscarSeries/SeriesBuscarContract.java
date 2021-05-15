package com.example.fandomoviesproject.buscarSeries;

import android.widget.TextView;

import com.example.fandomoviesproject.data.SerieItem;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

interface SeriesBuscarContract {

    interface View {

        void injectPresenter(Presenter presenter);
        void displaySeriesBuscarData(SeriesBuscarViewModel viewModel);

        void onClickCorazonButton(TextView titulo, TextView info);
        void navigateToBuscarPelisActivity();
        void navigateToBuscarDocusActivity();
        void onClickCarroButton(TextView titulo, TextView info);
        void añadidoConExitoWarning();

        void goToPaginaWeb();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        //TODO descomentar linea de abajo cuando repo este hecho y se haya implementado el metodo
        //void fetchSeriesBuscarData();
        void navigateToBuscarPelisActivity();
        void navigateToBuscarDocusActivity();

        void CorazonButtonClicked(TextView titulo, TextView info);
        void CarroButtonClicked(TextView titulo, TextView info);
    }

    interface Model {

        //TODO ESTO QUEDA PENDIENTE
        /*
        void fetchSeriesBuscarData(
                RepositoryContract.GetCategoryListCallback callback);

         */
    }


}
