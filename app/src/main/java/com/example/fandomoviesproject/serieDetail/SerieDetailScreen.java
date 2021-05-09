package com.example.fandomoviesproject.serieDetail;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.serieDetail.SerieDetailContract;
import com.example.fandomoviesproject.serieDetail.SerieDetailModel;
import com.example.fandomoviesproject.serieDetail.SerieDetailPresenter;

import java.lang.ref.WeakReference;

//import es.ulpgc.eite.cleancode.visitcanary.data.CatalogRepository;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


public class SerieDetailScreen {

    public static void configure(SerieDetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        //TODO Para cuando se haga el repo quitar descomentar linea de abajo
        //RepositoryContract repository = CatalogRepository.getInstance(context.get());

        SerieDetailContract.Presenter presenter = new SerieDetailPresenter(mediator);
        SerieDetailModel model = new SerieDetailModel();
        //TODO descomentar linea de abajo cuando repo este hecho
        //SerieDetailModel model = new SerieDetailModel(repository);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }

}

