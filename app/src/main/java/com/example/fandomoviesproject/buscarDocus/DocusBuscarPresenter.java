package com.example.fandomoviesproject.buscarDocus;

import android.widget.TextView;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.ComprasItem;
import com.example.fandomoviesproject.data.DocuItem;
import com.example.fandomoviesproject.data.FavoritoItem;

import java.lang.ref.WeakReference;

//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


public class DocusBuscarPresenter implements DocusBuscarContract.Presenter {

    public static String TAG = DocusBuscarPresenter.class.getSimpleName();

    private WeakReference<DocusBuscarContract.View> view;
    private DocusBuscarState state;
    private DocusBuscarContract.Model model;
    private AppMediator mediator;


    public DocusBuscarPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getDocusBuscarState();
    }


    //TODO ESTA METODO QUEDA PENDIENTE PARA CUANO SE IMPLEMENTE EL REPOSITORIO
    /*
    @Override
    public void fetchDocusBuscarData() {
        // Log.e(TAG, "fetchCategoryListData()");

        // call the model
        model.fetchDocusListData(new RepositoryContract.GetCategoryListCallback() {

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
    public void navigateToBuscarSeriesActivity() {
        view.get().navigateToBuscarSeriesActivity();
    }


    @Override
    public void injectView(WeakReference<DocusBuscarContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(DocusBuscarContract.Model model) {
        this.model = model;
    }

}
