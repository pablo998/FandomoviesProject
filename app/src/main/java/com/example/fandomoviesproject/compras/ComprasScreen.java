package com.example.fandomoviesproject.compras;

import androidx.fragment.app.FragmentActivity;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.compras.ComprasContract;
import com.example.fandomoviesproject.compras.ComprasModel;
import com.example.fandomoviesproject.compras.ComprasPresenter;

import java.lang.ref.WeakReference;

public class ComprasScreen {

    public static void configure(ComprasContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();

        ComprasContract.Presenter presenter=new ComprasPresenter(mediator);
        ComprasModel model = new ComprasModel();
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);

    }


}
