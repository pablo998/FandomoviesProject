package com.example.fandomoviesproject.ayuda;

import androidx.fragment.app.FragmentActivity;
import com.example.fandomoviesproject.app.AppMediator;
import java.lang.ref.WeakReference;

public class AyudaScreen {
    public static void configure(AyudaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();

        AyudaContract.Presenter presenter = new AyudaPresenter(mediator);
        AyudaModel model = new AyudaModel();
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }
}
