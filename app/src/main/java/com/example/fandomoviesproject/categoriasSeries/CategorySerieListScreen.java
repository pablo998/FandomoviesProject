package com.example.fandomoviesproject.categoriasSeries;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.Repository;
import com.example.fandomoviesproject.data.RepositoryContract;

import java.lang.ref.WeakReference;

public class CategorySerieListScreen {

    public static void configure(CategorySerieListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        RepositoryContract repository = Repository.getInstance(context.get());

        CategorySerieListContract.Presenter presenter = new CategorySerieListPresenter(mediator);
        CategorySerieListModel model = new CategorySerieListModel(repository);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }

}

