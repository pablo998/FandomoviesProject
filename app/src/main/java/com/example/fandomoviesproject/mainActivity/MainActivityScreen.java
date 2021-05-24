package com.example.fandomoviesproject.mainActivity;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;

import java.lang.ref.WeakReference;



public class MainActivityScreen {

    public static void configure(MainActivityContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();

        MainActivityContract.Presenter presenter=new MainActivityPresenter(mediator);
        MainActivityModel model = new MainActivityModel();
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }


}
