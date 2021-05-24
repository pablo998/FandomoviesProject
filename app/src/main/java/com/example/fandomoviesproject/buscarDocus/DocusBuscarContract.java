package com.example.fandomoviesproject.buscarDocus;

import android.widget.TextView;

import com.example.fandomoviesproject.data.RepositoryContract;

import java.lang.ref.WeakReference;


interface DocusBuscarContract {

    interface View {

        void injectPresenter(Presenter presenter);
        void displayDocusBuscarData(DocusBuscarViewModel viewModel);

        void onClickCorazonButton(TextView titulo, TextView info);
        void navigateToBuscarSeriesActivity();
        void navigateToBuscarPelisActivity();
        void onClickCarroButton(TextView titulo, TextView info, String urlComprar);
        void añadidoConExitoWarning();

        void goToPaginaWeb(String url);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        void fetchDocusBuscarData();
        void navigateToBuscarSeriesActivity();
        void navigateToBuscarPelisActivity();

        void CorazonButtonClicked(TextView titulo, TextView info);
        void CarroButtonClicked(TextView titulo, TextView info, String urlComprar);
    }

    interface Model {
        void fetchDocuBuscarData(RepositoryContract.GetDocusListCallback callback);
    }


}