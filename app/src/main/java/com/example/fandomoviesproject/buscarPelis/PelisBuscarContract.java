package com.example.fandomoviesproject.buscarPelis;

import android.view.View;
import android.widget.TextView;

import com.example.fandomoviesproject.data.PeliculaItem;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

interface PelisBuscarContract {

    interface View {

        void injectPresenter(Presenter presenter);
        void displayPelisBuscarData(PelisBuscarViewModel viewModel);

        void onClickCorazonButton(TextView titulo, TextView info);
        void onClickCarroButton(TextView titulo, TextView info);

        void navigateToBuscarSeriesActivity();
        void navigateToBuscarDocusActivity();
        void goToPaginaWeb();
        void añadidoConExitoWarning();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        //TODO descomentar linea de abajo cuando repo este hecho y se haya implementado el metodo
        //void fetchPelisBuscarData();
        void navigateToBuscarSeriesActivity();
        void navigateToBuscarDocusActivity();

        void CorazonButtonClicked(TextView titulo, TextView info);
        void CarroButtonClicked(TextView titulo, TextView info);

        //  void onResume();
        // void onStart();
        // void onRestart();
        //void onDestroy();
    }

    interface Model {

        //TODO ESTO QUEDA PENDIENTE
        /*
        void fetchPelisBuscarData(
                RepositoryContract.GetCategoryListCallback callback);

         */
    }


}