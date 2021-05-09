package com.example.fandomoviesproject.categoriasSeries;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.CatalogRepository;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

public class CategorySerieListScreen {

    public static void configure(CategorySerieListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        //TODO Para cuando se haga el repo quitar descomentar linea de abajo
        //RepositoryContract repository = CatalogRepository.getInstance(context.get());

        CategorySerieListContract.Presenter presenter = new CategorySerieListPresenter(mediator);
        //TODO descomentar linea de abajo cuando repo este hecho
        //CategoryListModel model = new CategoryListModel(repository);
        CategorySerieListModel model = new CategorySerieListModel();
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        //TODO descomentar cuando repo este hecho linea de abajo
        //presenter.injectModel(model);
        view.injectPresenter(presenter);

    }

}

