package com.example.fandomoviesproject.perfil;




import java.lang.ref.WeakReference;

public interface perfilContract {

    interface View{
        void injectPresenter(Presenter presenter);
    }

    interface Presenter{
        void injectView(WeakReference<perfilContract.View> view);
        void injectModel(perfilContract.Model model);
    }

    interface Model{

    }
}
