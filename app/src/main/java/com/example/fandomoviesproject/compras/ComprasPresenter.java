package com.example.fandomoviesproject.compras;

import com.example.fandomoviesproject.app.AppMediator;

import java.lang.ref.WeakReference;
import java.util.ArrayList;


public class ComprasPresenter implements ComprasContract.Presenter {

    public static String TAG = ComprasPresenter.class.getSimpleName();

    private WeakReference<ComprasContract.View> view;
    private ComprasState state;
    private ComprasContract.Model model;
    private AppMediator mediator;


    public ComprasPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getComprasState();
    }



    @Override
    public void fetchComprasData() {
        if(state.compras == null ){
            state.compras = new ArrayList<>();
        }
        if(mediator.getCompradoItems() != null) {
            state.compras = mediator.getCompradoItems();
            view.get().displayComprasData(state);
        }
    }

    @Override
    public void borrarListaDeCompras() {
        for (int i = 0; i < state.compras.size(); i++) {
            state.compras.removeAll(state.compras);
        }
        view.get().reiniciarPantalla();
    }




    @Override
    public void injectView(WeakReference<ComprasContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ComprasContract.Model model) {
        this.model = model;
    }

}
