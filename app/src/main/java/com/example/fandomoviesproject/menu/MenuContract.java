package com.example.fandomoviesproject.menu;

import java.lang.ref.WeakReference;

public interface MenuContract {

    interface View{
        void injectPresenter(Presenter presenter);
        void navigateToMoviesScreen();
        void navigateToSeriesScreen();
        void navigateToDocuScreen();

    }

    interface Presenter{
        void injectView(WeakReference<View> view);
        void moviesButtonClicked();
        void seriesButtonClicked();
        void documentaryButtonClicked();

    }

}
