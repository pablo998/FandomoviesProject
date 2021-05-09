package com.example.fandomoviesproject.seriesDeUnaCategoria;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListContract;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListModel;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListPresenter;

import java.lang.ref.WeakReference;

//import es.ulpgc.eite.cleancode.visitcanary.data.CatalogRepository;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

public class SerieListScreen {

    public static void configure(SerieListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        //TODO Para cuando se haga el repo quitar descomentar linea de abajo
        //RepositoryContract repository = CatalogRepository.getInstance(context.get());

        SerieListContract.Presenter presenter = new SerieListPresenter(mediator);
        SerieListModel model = new SerieListModel();
        //TODO descomentar linea de abajo cuando repo este hecho
        //SerieListModel model = new SerieListModel(repository);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }

}

