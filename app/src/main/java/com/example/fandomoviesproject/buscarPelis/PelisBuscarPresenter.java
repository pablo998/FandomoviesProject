package com.example.fandomoviesproject.buscarPelis;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.PeliculaItem;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


public class PelisBuscarPresenter implements PelisBuscarContract.Presenter {

    public static String TAG = PelisBuscarPresenter.class.getSimpleName();

    private WeakReference<PelisBuscarContract.View> view;
    private PelisBuscarState state;
    private PelisBuscarContract.Model model;
    private AppMediator mediator;


    public PelisBuscarPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getPelisBuscarState();
    }


    //TODO ESTA METODO QUEDA PENDIENTE PARA CUANO SE IMPLEMENTE EL REPOSITORIO
    /*
    @Override
    public void fetchPelisBuscarData() {
        // Log.e(TAG, "fetchCategoryListData()");

        // call the model
        model.fetchPelisListData(new RepositoryContract.GetCategoryListCallback() {

            @Override
            public void setCategoryList(List<CategoryItemCatalog> categories) {
                state.categories = categories;

                view.get().displayCategoryListData(state);
            }
        });

    }

     */

    private void passDataToFavoritosListActivity(PeliculaItem item) {
      //  mediator.setLikedPelicula(item);
    }

    private void passDataToComprasListActivity(PeliculaItem item) {
        //  mediator.setComprarPelicula(item);
    }

    @Override
    public void clickLike(PeliculaItem item) {
        passDataToFavoritosListActivity(item);
        view.get().changeCorazonColor();
    }

    @Override
    public void clickComprar(PeliculaItem item) {
        passDataToComprasListActivity(item);
        view.get().goToPaginaWeb();
    }

    @Override
    public void navigateToBuscarSeriesActivity() {
        view.get().navigateToBuscarSeriesActivity();
    }

    @Override
    public void navigateToBuscarDocusActivity() {
        view.get().navigateToBuscarDocusActivity();
    }


    @Override
    public void injectView(WeakReference<PelisBuscarContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(PelisBuscarContract.Model model) {
        this.model = model;
    }

}
