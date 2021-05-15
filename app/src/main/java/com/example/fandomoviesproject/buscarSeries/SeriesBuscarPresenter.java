package com.example.fandomoviesproject.buscarSeries;

import android.widget.TextView;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.ComprasItem;
import com.example.fandomoviesproject.data.FavoritoItem;
import com.example.fandomoviesproject.data.SerieItem;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


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


    //TODO ESTA METODO QUEDA PENDIENTE PARA CUANO SE IMPLEMENTE EL REPOSITORIO
    /*
    @Override
    public void fetchSeriesBuscarData() {
        // Log.e(TAG, "fetchCategoryListData()");

        // call the model
        model.fetchSeriesListData(new RepositoryContract.GetCategoryListCallback() {

            @Override
            public void setCategoryList(List<CategoryItemCatalog> categories) {
                state.categories = categories;

                view.get().displayCategoryListData(state);
            }
        });

    }

     */

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
        FavoritoItem peliculaFavorita = new FavoritoItem(tituloFav, infoFav, 0, 0);
        passDataToFavoritosActivity(peliculaFavorita);
        view.get().añadidoConExitoWarning();
    }

    @Override
    public void CarroButtonClicked(TextView titulo, TextView info) {
        String tituloFav = titulo.getText().toString();
        String infoFav = info.getText().toString();
        ComprasItem peliculaComprada = new ComprasItem(tituloFav, infoFav, 0);
        passDataToComprasListActivity(peliculaComprada);
        //view.get().goToPaginaWeb();
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
