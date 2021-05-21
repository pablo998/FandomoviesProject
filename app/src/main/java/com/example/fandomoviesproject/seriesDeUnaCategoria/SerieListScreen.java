package com.example.fandomoviesproject.seriesDeUnaCategoria;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.Repository;
import com.example.fandomoviesproject.data.RepositoryContract;
import java.lang.ref.WeakReference;

public class SerieListScreen {

    public static void configure(SerieListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        RepositoryContract repository = Repository.getInstance(context.get());

        SerieListContract.Presenter presenter = new SerieListPresenter(mediator);
        SerieListModel model = new SerieListModel(repository);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }

}

