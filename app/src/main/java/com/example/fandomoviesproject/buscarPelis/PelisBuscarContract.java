package com.example.fandomoviesproject.buscarPelis;

import android.widget.TextView;
import com.example.fandomoviesproject.data.RepositoryContract;
import java.lang.ref.WeakReference;

interface PelisBuscarContract {

    interface View {

        void injectPresenter(Presenter presenter);
        void displayPelisBuscarData(PelisBuscarViewModel viewModel);

        void onClickCorazonButton(TextView titulo, TextView info);
        void onClickCarroButton(TextView titulo, TextView info, String URLcompra);

        void navigateToBuscarSeriesActivity();
        void navigateToBuscarDocusActivity();
        void goToPaginaWeb(String URL);
        void añadidoConExitoWarning();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        void fetchPelisBuscarData();
        void navigateToBuscarSeriesActivity();
        void navigateToBuscarDocusActivity();

        void CorazonButtonClicked(TextView titulo, TextView info);
        void CarroButtonClicked(TextView titulo, TextView info, String URLcompra);
    }

    interface Model {

        void fetchPeliBuscarData(RepositoryContract.GetPelisListCallback callback);
    }


}