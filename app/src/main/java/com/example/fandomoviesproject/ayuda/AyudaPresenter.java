package com.example.fandomoviesproject.ayuda;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.compras.ComprasState;


import java.lang.ref.WeakReference;

public class AyudaPresenter implements AyudaContract.Presenter {

    public static String TAG = AyudaPresenter.class.getSimpleName();

    private WeakReference<AyudaContract.View> view;
    private AyudaState state;
    private AyudaContract.Model model;
    private AppMediator mediator;

    public AyudaPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getAyudaState();
    }

    @Override
    public void injectView(WeakReference<AyudaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AyudaContract.Model model) {
        this.model = model;
    }

    @Override
    public void fetchAyudaData() {
        String ayudaText = model.fetchAyudaData();
        state.informacion = ayudaText;
        view.get().displayAyudaData(state);
    }

}
