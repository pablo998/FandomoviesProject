package com.example.fandomoviesproject.registrarse;

import androidx.fragment.app.FragmentActivity;
import com.example.fandomoviesproject.app.AppMediator;
import java.lang.ref.WeakReference;

public class RegistrarseScreen {

    public static void configure(RegistrarseContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();

        RegistrarseContract.Presenter presenter=new RegistrarsePresenter(mediator);
        RegistrarseModel model = new RegistrarseModel();
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }


}
