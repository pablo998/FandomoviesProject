package com.example.fandomoviesproject.compras;

import com.example.fandomoviesproject.data.FavoritoItem;
import com.example.fandomoviesproject.favoritos.FavoritosViewModel;

import java.lang.ref.WeakReference;

interface ComprasContract {

    interface View {

        void injectPresenter(Presenter presenter);
        void displayComprasData(ComprasViewModel viewModel);
        void borrarListaDeCompras();
        void reiniciarPantalla();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        void fetchComprasData();
        void borrarListaDeCompras();    }

    interface Model {

        //void fetchFavoritosData();
    }


}