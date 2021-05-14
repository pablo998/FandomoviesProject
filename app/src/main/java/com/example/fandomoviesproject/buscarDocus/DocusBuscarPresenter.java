package com.example.fandomoviesproject.buscarDocus;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.DocuItem;

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

    private void passDataToFavoritosListActivity(DocuItem item) {
        //  mediator.setLikedDocumental(item);
    }

    private void passDataToComprasListActivity(DocuItem item) {
        //  mediator.setComprarDocumental(item);
    }

    @Override
    public void clickLike(DocuItem item) {
        passDataToFavoritosListActivity(item);
        view.get().changeCorazonColor();
    }

    @Override
    public void clickComprar(DocuItem item) {
        passDataToComprasListActivity(item);
        view.get().goToPaginaWeb();
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
