package com.example.fandomoviesproject.categoriasDocu;

import androidx.fragment.app.FragmentActivity;
import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.Repository;
import com.example.fandomoviesproject.data.RepositoryContract;
import java.lang.ref.WeakReference;

public class CategoryDocuListScreen {

    public static void configure(CategoryDocuListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);


        AppMediator mediator = AppMediator.getInstance();
        RepositoryContract repository = Repository.getInstance(context.get());

        CategoryDocuListContract.Presenter presenter = new CategoryDocuListPresenter(mediator);
        CategoryDocuListContract.Model model = new CategoryDocuListModel(repository);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));
        view.injectPresenter(presenter);

    }
}
