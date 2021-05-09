package com.example.fandomoviesproject.buscarDocus;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.CatalogRepository;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


public class DocusBuscarScreen {

    public static void configure(DocusBuscarContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        //TODO Para cuando se haga el repo quitar descomentar linea de abajo
        // RepositoryContract repository = CatalogRepository.getInstance(context.get());

        DocusBuscarContract.Presenter presenter=new DocusBuscarPresenter(mediator);
        //TODO descomentar linea de abajo cuando repo este hecho
        // DocusBuscarModel model = new DocusBuscarModel(repository);
        presenter.injectView(new WeakReference<>(view));
        //TODO descomentar cuando repo este hecho linea de abajo
        // presenter.injectModel(model);
        view.injectPresenter(presenter);

    }


}

