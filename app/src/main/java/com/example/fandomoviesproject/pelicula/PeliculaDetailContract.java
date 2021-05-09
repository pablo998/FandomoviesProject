package com.example.fandomoviesproject.pelicula;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


interface PeliculaDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayPeliculaDetailData(PeliculaDetailViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);
        String getPeliculaName();
        // String getPeliculaNameConRepo();
        void fetchPeliculaDetailData();
    }

    interface Model {
        //TODO. QUEDA PENDIENTE
        /*
        void fetchPeliculaDetailData(
                RepositoryContract.GetPeliculaDetailCallback callback);

         */
    }

}
