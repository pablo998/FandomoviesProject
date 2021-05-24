package com.example.fandomoviesproject.buscarSeries;

import android.widget.TextView;

import com.example.fandomoviesproject.data.RepositoryContract;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

interface SeriesBuscarContract {

    interface View {

        void injectPresenter(Presenter presenter);

        void displaySeriesBuscarData(SeriesBuscarViewModel viewModel);

        void onClickCorazonButton(TextView titulo, TextView info);

        void navigateToBuscarPelisActivity();

        void navigateToBuscarDocusActivity();

        void onClickCarroButton(TextView titulo, TextView info, String urlComprar);

        void añadidoConExitoWarning();

        void goToPaginaWeb(String url);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void fetchSeriesBuscarData();
        void navigateToBuscarPelisActivity();

        void navigateToBuscarDocusActivity();

        void CorazonButtonClicked(TextView titulo, TextView info);

        void CarroButtonClicked(TextView titulo, TextView info, String urlComprar);
    }

    interface Model {

        void fetchSerieBuscarData(RepositoryContract.GetSeriesListCallback callback);


    }
}
