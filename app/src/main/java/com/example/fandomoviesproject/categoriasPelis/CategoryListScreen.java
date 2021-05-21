package com.example.fandomoviesproject.categoriasPelis;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.Repository;
import com.example.fandomoviesproject.data.RepositoryContract;


public class CategoryListScreen {

    public static void configure(CategoryListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        RepositoryContract repository = Repository.getInstance(context.get());

        CategoryListContract.Presenter presenter = new CategoryListPresenter(mediator);
        CategoryListModel model = new CategoryListModel(repository);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }

}

