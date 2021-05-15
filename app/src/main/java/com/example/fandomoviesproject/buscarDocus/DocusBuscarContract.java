package com.example.fandomoviesproject.buscarDocus;

import android.widget.TextView;

import com.example.fandomoviesproject.data.DocuItem;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

interface DocusBuscarContract {

    interface View {

        void injectPresenter(Presenter presenter);
        void displayDocusBuscarData(DocusBuscarViewModel viewModel);

        void onClickCorazonButton(TextView titulo, TextView info);
        void navigateToBuscarSeriesActivity();
        void navigateToBuscarPelisActivity();
        void onClickCarroButton(TextView titulo, TextView info);
        void añadidoConExitoWarning();

        void goToPaginaWeb();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        //TODO descomentar linea de abajo cuando repo este hecho y se haya implementado el metodo
        //void fetchDocusBuscarData();
        void navigateToBuscarSeriesActivity();
        void navigateToBuscarPelisActivity();

        void CorazonButtonClicked(TextView titulo, TextView info);
        void CarroButtonClicked(TextView titulo, TextView info);
    }

    interface Model {

        //TODO ESTO QUEDA PENDIENTE
        /*
        void fetchDocusBuscarData(
                RepositoryContract.GetCategoryListCallback callback);

         */
    }


}