package com.example.fandomoviesproject.menu;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;

import java.lang.ref.WeakReference;

public class MenuScreen {

    public static void configure(MenuContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        //String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        MenuContract.Presenter presenter = new MenuPresenter(mediator);
        presenter.injectView(new WeakReference<>(view));
        view.injectPresenter(presenter);

    }
}
