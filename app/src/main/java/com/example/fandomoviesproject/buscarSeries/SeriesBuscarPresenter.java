package com.example.fandomoviesproject.buscarSeries;

import com.example.fandomoviesproject.app.AppMediator;
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

    private void passDataToFavoritosListActivity(SerieItem item) {
        //  mediator.setLikedSerie(item);
    }

    private void passDataToComprasListActivity(SerieItem item) {
        //  mediator.setComprarSerie(item);
    }

    @Override
    public void clickLike(SerieItem item) {
        passDataToFavoritosListActivity(item);
        view.get().changeCorazonColor();
    }

    @Override
    public void clickComprar(SerieItem item) {
        passDataToComprasListActivity(item);
        view.get().goToPaginaWeb();
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
