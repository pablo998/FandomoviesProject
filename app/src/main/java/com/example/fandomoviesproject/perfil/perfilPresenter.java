package com.example.fandomoviesproject.perfil;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.User;
import com.example.fandomoviesproject.menu.MenuContract;

import java.lang.ref.WeakReference;

public class perfilPresenter implements perfilContract.Presenter {

    public static String TAG = perfilPresenter.class.getSimpleName();

    private WeakReference<perfilContract.View> view;
    private perfilState state;
    private perfilContract.Model model;
    private AppMediator mediator;

    public perfilPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getPerfilState();
    }


    @Override
    public void injectView(WeakReference<perfilContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(perfilContract.Model model) {
        this.model = model;
    }

    @Override
    public void loadData() {
        User userActual = mediator.getUserActual();
        view.get().loadDataView(userActual);
    }


}
