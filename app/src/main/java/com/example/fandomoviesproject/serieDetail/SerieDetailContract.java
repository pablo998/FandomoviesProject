package com.example.fandomoviesproject.serieDetail;

import com.example.fandomoviesproject.serieDetail.SerieDetailViewModel;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


interface SerieDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displaySerieDetailData(SerieDetailViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);
        String getSerieName();
        // String getSerieNameConRepo();
        void fetchSerieDetailData();
    }

    interface Model {
        //TODO. QUEDA PENDIENTE
        /*
        void fetchSerieDetailData(
                RepositoryContract.GetSerieDetailCallback callback);

         */
    }

}
