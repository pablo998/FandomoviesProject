package com.example.fandomoviesproject.perfil;




import com.example.fandomoviesproject.data.User;

import java.lang.ref.WeakReference;

public interface perfilContract {

    interface View{
        void injectPresenter(Presenter presenter);

        void loadDataView(User userActual);
        void onClickCerrarSesion();
    }

    interface Presenter{
        void injectView(WeakReference<perfilContract.View> view);
        void injectModel(perfilContract.Model model);

        void loadData();
        void onClickCerrarSesion();
    }

    interface Model{

    }
}
