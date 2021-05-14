package com.example.fandomoviesproject.categoriasDocu;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.categoriasSeries.CategorySerieListModel;

import java.lang.ref.WeakReference;

public class CategoryDocuListScreen {

    public static void configure(CategoryDocuListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);


        AppMediator mediator = AppMediator.getInstance();
        //TODO Para cuando se haga el repo quitar descomentar linea de abajo
        //RepositoryContract repository = CatalogRepository.getInstance(context.get());

        CategoryDocuListContract.Presenter presenter = new CategoryDocuListPresenter(mediator);
        //TODO descomentar linea de abajo cuando repo este hecho
        //CategoryListModel model = new CategoryListModel(repository);
        CategoryDocuListModel model = new CategoryDocuListModel();
        presenter.injectModel(model);
        //TODO descomentar cuando repo este hecho linea de abajo
        //presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
