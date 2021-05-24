package com.example.fandomoviesproject.buscarDocus;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.Repository;
import com.example.fandomoviesproject.data.RepositoryContract;

import java.lang.ref.WeakReference;



public class DocusBuscarScreen {

    public static void configure(DocusBuscarContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        RepositoryContract repository = Repository.getInstance(context.get());

        DocusBuscarContract.Presenter presenter=new DocusBuscarPresenter(mediator);
        DocusBuscarModel model = new DocusBuscarModel(repository);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }


}

