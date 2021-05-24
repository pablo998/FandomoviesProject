package com.example.fandomoviesproject.buscarSeries;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.Repository;
import com.example.fandomoviesproject.data.RepositoryContract;

import java.lang.ref.WeakReference;



public class SeriesBuscarScreen {

    public static void configure(SeriesBuscarContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        RepositoryContract repository = Repository.getInstance(context.get());

        SeriesBuscarContract.Presenter presenter=new SeriesBuscarPresenter(mediator);
        SeriesBuscarModel model = new SeriesBuscarModel(repository);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }


}
