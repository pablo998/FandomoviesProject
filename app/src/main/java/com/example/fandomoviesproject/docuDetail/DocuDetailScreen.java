package com.example.fandomoviesproject.docuDetail;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;

import java.lang.ref.WeakReference;

public class DocuDetailScreen {

    public static void configure(DocuDetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);



        AppMediator mediator = AppMediator.getInstance();
        //TODO Para cuando se haga el repo quitar descomentar linea de abajo
        //RepositoryContract repository = CatalogRepository.getInstance(context.get());

        DocuDetailContract.Presenter presenter = new DocuDetailPresenter(mediator);
        DocuDetailContract.Model model = new DocuDetailModel();
        //TODO descomentar linea de abajo cuando repo este hecho
        //PeliculaDetailModel model = new PeliculaDetailModel(repository);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
