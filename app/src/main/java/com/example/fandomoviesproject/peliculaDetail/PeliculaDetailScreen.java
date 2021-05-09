package com.example.fandomoviesproject.peliculaDetail;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import com.example.fandomoviesproject.app.AppMediator;

//import es.ulpgc.eite.cleancode.visitcanary.data.CatalogRepository;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


public class PeliculaDetailScreen {

    public static void configure(PeliculaDetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        //TODO Para cuando se haga el repo quitar descomentar linea de abajo
        //RepositoryContract repository = CatalogRepository.getInstance(context.get());

        PeliculaDetailContract.Presenter presenter = new PeliculaDetailPresenter(mediator);
        PeliculaDetailModel model = new PeliculaDetailModel();
        //TODO descomentar linea de abajo cuando repo este hecho
        //PeliculaDetailModel model = new PeliculaDetailModel(repository);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }

}

