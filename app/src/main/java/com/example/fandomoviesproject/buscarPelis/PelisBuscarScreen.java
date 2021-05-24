package com.example.fandomoviesproject.buscarPelis;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.Repository;
import com.example.fandomoviesproject.data.RepositoryContract;

import java.lang.ref.WeakReference;


public class PelisBuscarScreen {

    public static void configure(PelisBuscarContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        RepositoryContract repository = Repository.getInstance(context.get());

        PelisBuscarContract.Presenter presenter=new PelisBuscarPresenter(mediator);
        PelisBuscarModel model = new PelisBuscarModel(repository);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }


}
