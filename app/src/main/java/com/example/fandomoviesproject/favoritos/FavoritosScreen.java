package com.example.fandomoviesproject.favoritos;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;

import java.lang.ref.WeakReference;

public class FavoritosScreen {

    public static void configure(FavoritosContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();

        FavoritosContract.Presenter presenter=new FavoritosPresenter(mediator);
        FavoritosModel model = new FavoritosModel();
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }


}
