package com.example.fandomoviesproject.docusDeUnaCategoria;

import androidx.fragment.app.FragmentActivity;
import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.Repository;
import com.example.fandomoviesproject.data.RepositoryContract;
import java.lang.ref.WeakReference;

public class DocuListScreen {

    public static void configure(DocuListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);



        AppMediator mediator = AppMediator.getInstance();
        RepositoryContract repository = Repository.getInstance(context.get());

        DocuListContract.Presenter presenter = new DocuListPresenter(mediator);
        DocuListModel model = new DocuListModel(repository);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));
        view.injectPresenter(presenter);

    }
}
