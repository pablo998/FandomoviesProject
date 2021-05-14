package com.example.fandomoviesproject.buscarDocus;

import com.example.fandomoviesproject.data.DocuItem;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

interface DocusBuscarContract {

    interface View {

        void injectPresenter(Presenter presenter);
        void displayDocusBuscarData(DocusBuscarViewModel viewModel);

        void navigateToBuscarSeriesActivity();
        void navigateToBuscarPelisActivity();
        void changeCorazonColor();
        void goToPaginaWeb();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        //TODO descomentar linea de abajo cuando repo este hecho y se haya implementado el metodo
        //void fetchDocusBuscarData();
        void navigateToBuscarSeriesActivity();
        void navigateToBuscarPelisActivity();

        void clickLike(DocuItem documental);
        void clickComprar(DocuItem documental);
    }

    interface Model {

        //TODO ESTO QUEDA PENDIENTE
        /*
        void fetchDocusBuscarData(
                RepositoryContract.GetCategoryListCallback callback);

         */
    }


}