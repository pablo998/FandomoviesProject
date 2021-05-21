package com.example.fandomoviesproject.serieDetail;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.Repository;
import com.example.fandomoviesproject.data.RepositoryContract;
import com.example.fandomoviesproject.serieDetail.SerieDetailContract;
import com.example.fandomoviesproject.serieDetail.SerieDetailModel;
import com.example.fandomoviesproject.serieDetail.SerieDetailPresenter;

import java.lang.ref.WeakReference;




public class SerieDetailScreen {

    public static void configure(SerieDetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();

        SerieDetailContract.Presenter presenter = new SerieDetailPresenter(mediator);
        SerieDetailModel model = new SerieDetailModel();
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }

}

