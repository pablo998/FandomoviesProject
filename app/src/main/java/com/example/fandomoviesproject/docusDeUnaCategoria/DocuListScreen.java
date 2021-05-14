package com.example.fandomoviesproject.docusDeUnaCategoria;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;

import java.lang.ref.WeakReference;

public class DocuListScreen {

    public static void configure(DocuListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);



        AppMediator mediator = AppMediator.getInstance();
        //TODO Para cuando se haga el repo quitar descomentar linea de abajo
        //RepositoryContract repository = CatalogRepository.getInstance(context.get());

        DocuListContract.Presenter presenter = new DocuListPresenter(mediator);
        DocuListContract.Model model = new DocuListModel();
        //TODO descomentar linea de abajo cuando repo este hecho
        //SerieListModel model = new SerieListModel(repository);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
