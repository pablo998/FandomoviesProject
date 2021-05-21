package com.example.fandomoviesproject.peliculasDeUnaCategoria;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.Repository;
import com.example.fandomoviesproject.data.RepositoryContract;

public class PeliculaListScreen {

    public static void configure(PeliculaListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        RepositoryContract repository = Repository.getInstance(context.get());

        PeliculaListContract.Presenter presenter = new PeliculaListPresenter(mediator);
        PeliculaListModel model = new PeliculaListModel(repository);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }

}

