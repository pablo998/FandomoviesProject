package com.example.fandomoviesproject.peliculas;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import com.example.fandomoviesproject.app.AppMediator;

//import es.ulpgc.eite.cleancode.visitcanary.data.CatalogRepository;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

public class PeliculaListScreen {

    public static void configure(PeliculaListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        //TODO Para cuando se haga el repo quitar descomentar linea de abajo
        //RepositoryContract repository = CatalogRepository.getInstance(context.get());

        PeliculaListContract.Presenter presenter = new PeliculaListPresenter(mediator);
        PeliculaListModel model = new PeliculaListModel();
        //TODO descomentar linea de abajo cuando repo este hecho
        //PeliculaListModel model = new PeliculaListModel(repository);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }

}

