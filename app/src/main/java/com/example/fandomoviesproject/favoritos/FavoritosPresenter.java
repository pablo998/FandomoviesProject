package com.example.fandomoviesproject.favoritos;

import android.widget.TextView;

import com.example.fandomoviesproject.app.AppMediator;

import java.lang.ref.WeakReference;
import java.util.ArrayList;


public class FavoritosPresenter implements FavoritosContract.Presenter {

    public static String TAG = FavoritosPresenter.class.getSimpleName();

    private WeakReference<FavoritosContract.View> view;
    private FavoritosState state;
    private FavoritosContract.Model model;
    private AppMediator mediator;


    public FavoritosPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getFavoritosState();
    }



    @Override
    public void fetchFavoritosData() {
        if(state.favoritos == null){
            state.favoritos = new ArrayList<>();
        }
        if(mediator.getLikedItems() != null) {
            state.favoritos = mediator.getLikedItems();
            view.get().displayFavoritosData(state);
        }
    }



    @Override
    public void onClickDeleteButton(TextView mTitleText, TextView mInfoText) {
        for (int i = 0; i < state.favoritos.size(); i++) {
            if((state.favoritos.get(i).getTitle().equals(mTitleText.getText().toString())))
                state.favoritos.remove(i);
        }
        view.get().reiniciarPantalla();
    }



    @Override
    public void injectView(WeakReference<FavoritosContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(FavoritosContract.Model model) {
        this.model = model;
    }

}
