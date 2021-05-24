package com.example.fandomoviesproject.buscarSeries;

import android.util.Log;
import android.widget.TextView;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.ComprasItem;
import com.example.fandomoviesproject.data.FavoritoItem;
import com.example.fandomoviesproject.data.RepositoryContract;
import com.example.fandomoviesproject.data.SerieItemCatalog;

import java.lang.ref.WeakReference;
import java.util.List;


public class SeriesBuscarPresenter implements SeriesBuscarContract.Presenter {

    public static String TAG = SeriesBuscarPresenter.class.getSimpleName();

    private WeakReference<SeriesBuscarContract.View> view;
    private SeriesBuscarState state;
    private SeriesBuscarContract.Model model;
    private AppMediator mediator;


    public SeriesBuscarPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getSeriesBuscarState();
    }


    @Override
    public void fetchSeriesBuscarData() {
        Log.e(TAG, "fetchSeriesListData()");

        // call the model
        model.fetchSerieBuscarData(new RepositoryContract.GetSeriesListCallback() {

            @Override
            public void setSeriesList(List<SerieItemCatalog> products) {
                state.series = products;

                view.get().displaySeriesBuscarData(state);
            }
        });
    }

    private void passDataToFavoritosActivity(FavoritoItem item) {
        mediator.setLiked(item);
    }


    private void passDataToComprasListActivity(ComprasItem item) {
        mediator.setHeComprado(item);
    }


    @Override
    public void CorazonButtonClicked(TextView titulo, TextView info) {
        String tituloFav = titulo.getText().toString();
        String infoFav = info.getText().toString();
        FavoritoItem serieFavorita = new FavoritoItem(tituloFav, infoFav, 0, 0);
        passDataToFavoritosActivity(serieFavorita);
        view.get().añadidoConExitoWarning();
    }

    @Override
    public void CarroButtonClicked(TextView titulo, TextView info, String urlComprar) {
        String tituloFav = titulo.getText().toString();
        String infoFav = info.getText().toString();
        ComprasItem serieComprada = new ComprasItem(tituloFav, infoFav, 0);
        passDataToComprasListActivity(serieComprada);
        view.get().goToPaginaWeb(urlComprar);
    }

    @Override
    public void navigateToBuscarPelisActivity() {
        view.get().navigateToBuscarPelisActivity();
    }

    @Override
    public void navigateToBuscarDocusActivity() {
        view.get().navigateToBuscarDocusActivity();
    }


    @Override
    public void injectView(WeakReference<SeriesBuscarContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(SeriesBuscarContract.Model model) {
        this.model = model;
    }

}
