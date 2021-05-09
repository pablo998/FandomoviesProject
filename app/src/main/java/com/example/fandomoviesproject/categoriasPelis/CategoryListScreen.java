package com.example.fandomoviesproject.categoriasPelis;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import com.example.fandomoviesproject.app.AppMediator;
//import es.ulpgc.eite.cleancode.visitcanary.data.CatalogRepository;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

public class CategoryListScreen {

    public static void configure(CategoryListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        //TODO Para cuando se haga el repo quitar descomentar linea de abajo
        //RepositoryContract repository = CatalogRepository.getInstance(context.get());

        CategoryListContract.Presenter presenter = new CategoryListPresenter(mediator);
        //TODO descomentar linea de abajo cuando repo este hecho
        //CategoryListModel model = new CategoryListModel(repository);
        CategoryListModel model = new CategoryListModel();
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        //TODO descomentar cuando repo este hecho linea de abajo
        //presenter.injectModel(model);
        view.injectPresenter(presenter);

    }

}

