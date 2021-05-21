package com.example.fandomoviesproject.serieDetail;

import java.lang.ref.WeakReference;


interface SerieDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displaySerieDetailData(SerieDetailViewModel viewModel);
        void navigateToURLtrailer(String URLtrailer);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        void onClickTrailerButton();
        void fetchSerieDetailData();
    }

    interface Model {

    }

}
