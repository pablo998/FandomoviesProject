package com.example.fandomoviesproject.ayuda;

import com.example.fandomoviesproject.app.AppMediator;



import java.lang.ref.WeakReference;

public class AyudaPresenter implements AyudaContract.Presenter {

    public static String TAG = AyudaPresenter.class.getSimpleName();

    private WeakReference<AyudaContract.View> view;
    private AyudaContract.Model model;
    private AppMediator mediator;

    public AyudaPresenter(AppMediator mediator) {
        this.mediator = mediator;

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
        //TODO pendiente
    }

}
