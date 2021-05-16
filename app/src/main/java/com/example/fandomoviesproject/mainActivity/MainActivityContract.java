package com.example.fandomoviesproject.mainActivity;

import android.widget.TextView;

import java.lang.ref.WeakReference;


public interface MainActivityContract {
    interface View {
        void injectPresenter(MainActivityContract.Presenter presenter);

        void navigateToMenuActivity();
        void navigateToRegistrarseActivity();

        void credencialesIncorrectas();
    }

    interface Presenter {
        void injectView(WeakReference<MainActivityContract.View> view);
        void injectModel(MainActivityContract.Model model);

        void onIniciarSesionButtonClick(TextView numMoviloEmail, TextView contraseña);
        void onRegistrateButtonClick();

    }


    public interface Model {

        //TODO ESTO QUEDA PENDIENTE
        /*
        boolean comprobarQueNoEstaEmail(
                RepositoryContract.GetCategoryListCallback callback);
        boolean comprobarQueNoEstaNumMovil(
                RepositoryContract.GetCategoryListCallback callback);
         */


    }
}

