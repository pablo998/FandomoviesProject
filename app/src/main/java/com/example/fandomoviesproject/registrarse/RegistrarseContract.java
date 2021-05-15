package com.example.fandomoviesproject.registrarse;




import android.widget.TextView;

import java.lang.ref.WeakReference;


public interface RegistrarseContract {
    interface View {
        void injectPresenter(RegistrarseContract.Presenter presenter);
        void navigateToMenuActivity();
        void faltanCamposPorRellenar();
        void emailYaRegistrado();
        void numeroDeMovilYaRegistrado();
    }

    interface Presenter {
        void injectView(WeakReference<RegistrarseContract.View> view);
        void injectModel(RegistrarseContract.Model model);
        void onClickRegistrarme(int currentTab, TextView nombreYapellidos, TextView contraseña,
                                TextView numMovil, TextView email);
    }


    public interface Model {

        //TODO ESTO QUEDA PENDIENTE
        /*
        boolean comprobarQueNoEstaEmail(
                RepositoryContract.GetCategoryListCallback callback);
        boolean comprobarQueNoEstaNumMovil(
                RepositoryContract.GetCategoryListCallback callback);

        void guardarEnBaseDeDatos(
                RepositoryContract.GetCategoryListCallback callback);

         */


    }
}

