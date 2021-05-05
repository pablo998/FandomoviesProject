package com.example.fandomoviesproject.menu;

import java.lang.ref.WeakReference;

public interface MenuContract {

    interface View{
        void injectPresenter(Presenter presenter);


    }

    interface Presenter{
        void injectView(WeakReference<View> view);
        void moviesButtonClicked();
        void seriesButtonClicked();
        void documentaryButtonClicked();

    }

}
