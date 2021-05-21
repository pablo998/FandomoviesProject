package com.example.fandomoviesproject.peliculaDetail;

import java.lang.ref.WeakReference;

interface PeliculaDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayPeliculaDetailData(PeliculaDetailViewModel viewModel);
        void navigateToURLtrailer(String URLtrailer);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        void onClickTrailerButton();
        void fetchPeliculaDetailData();
    }

    interface Model {

    }
}
