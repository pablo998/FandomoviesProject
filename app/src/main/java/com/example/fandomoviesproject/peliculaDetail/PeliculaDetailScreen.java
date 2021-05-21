package com.example.fandomoviesproject.peliculaDetail;

import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import com.example.fandomoviesproject.app.AppMediator;


public class PeliculaDetailScreen {

    public static void configure(PeliculaDetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();

        PeliculaDetailContract.Presenter presenter = new PeliculaDetailPresenter(mediator);
        PeliculaDetailModel model = new PeliculaDetailModel();
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }

}

