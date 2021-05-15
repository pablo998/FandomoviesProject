package com.example.fandomoviesproject.perfil;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;

import java.lang.ref.WeakReference;

public class perfilScreen {

    public static void configure(perfilContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        //String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        perfilContract.Presenter presenter = new perfilPresenter(mediator);
        perfilContract.Model model = new perfilModel();
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
