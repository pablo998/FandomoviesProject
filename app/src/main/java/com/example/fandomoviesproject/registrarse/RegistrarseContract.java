package com.example.fandomoviesproject.registrarse;




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
        void onClickRegistrarme(int currentTab);
    }


    public interface Model {

        //TODO ESTO QUEDA PENDIENTE
        /*
        void comprobarQueNoEstaEmail(
                RepositoryContract.GetCategoryListCallback callback);
        void comprobarQueNoEstaNumMovil(
                RepositoryContract.GetCategoryListCallback callback);

        void guardarEnBaseDeDatos(
                RepositoryContract.GetCategoryListCallback callback);

         */


    }
}

