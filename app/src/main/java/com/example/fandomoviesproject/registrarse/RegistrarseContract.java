package com.example.fandomoviesproject.registrarse;




import android.text.Editable;
import android.widget.TextView;

import java.lang.ref.WeakReference;


public interface RegistrarseContract {
    interface View {
        void injectPresenter(RegistrarseContract.Presenter presenter);

        void navigateToMenuActivity();
        void faltanCamposPorRellenar();
        void emailYaRegistrado();
        void numeroDeMovilYaRegistrado();

        void updateNumeroDeMovil(String numeroMovil);
        void updatePassword(String password);
        void updateEmail(String email);
        void updateNombreYapellidos(String nombreYapellidos);
        void updateTab(int currentTab);
    }

    interface Presenter {
        void injectView(WeakReference<RegistrarseContract.View> view);
        void injectModel(RegistrarseContract.Model model);
        void onClickRegistrarme(int currentTab, TextView nombreYapellidos, TextView contraseña,
                                TextView numMovil, TextView email);
        void textChanged(Editable text);
        void passwordChanged(Editable text);
        void numMovilChanged(Editable text);
        void emailChanged(Editable text);
        void onTabChanged(String tabId);

        void updateView();

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

