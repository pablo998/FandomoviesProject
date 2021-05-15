package com.example.fandomoviesproject.favoritos;

import android.widget.TextView;

import com.example.fandomoviesproject.data.FavoritoItem;

import java.lang.ref.WeakReference;

interface FavoritosContract {

    interface View {

        void injectPresenter(Presenter presenter);
        void displayFavoritosData(FavoritosViewModel viewModel);
        void todaviaNoHayFavoritos();
        void onClickDeleteButton(TextView mTitleText, TextView mInfoText);
        void reiniciarPantalla();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        void fetchFavoritosData();
        void onClickDeleteButton(TextView mTitleText, TextView mInfoText);
    }

    interface Model {

        //void fetchFavoritosData();
    }


}