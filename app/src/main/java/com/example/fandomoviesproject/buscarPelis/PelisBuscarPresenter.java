package com.example.fandomoviesproject.buscarPelis;

import android.util.Log;
import android.widget.TextView;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.ComprasItem;
import com.example.fandomoviesproject.data.FavoritoItem;
import com.example.fandomoviesproject.data.PeliculaItem;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
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



   /* @Override
    public void onResume() {
        Log.e(TAG, "onResume()");

        if(state.titulosLiked.size() != 0){
            view.get().displayPelisBuscarData(state);
        }
    }

    */
}


