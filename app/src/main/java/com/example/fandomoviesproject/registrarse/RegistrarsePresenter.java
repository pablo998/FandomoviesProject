package com.example.fandomoviesproject.registrarse;

import android.widget.TextView;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.ComprasItem;
import com.example.fandomoviesproject.data.FavoritoItem;
import com.example.fandomoviesproject.data.SerieItem;
import com.example.fandomoviesproject.registrarse.RegistrarseContract;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


public class RegistrarsePresenter implements RegistrarseContract.Presenter {

    public static String TAG = RegistrarsePresenter.class.getSimpleName();

    private WeakReference<RegistrarseContract.View> view;
    private RegistrarseState state;
    private RegistrarseContract.Model model;
    private AppMediator mediator;


    public RegistrarsePresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getRegistrarseState();
    }


    @Override
    public void onClickRegistrarme(int currentTab, TextView nombreYapellidos, TextView contraseña,
                                   TextView numMovil, TextView email){
        switch (currentTab){
            case 0:
                if(nombreYapellidos == null || contraseña == null || email == null){
                    view.get().faltanCamposPorRellenar();
                }else {
                    state.contraseña = contraseña.getText().toString();
                    state.email = email.getText().toString();
                    state.nombreYapellidos = nombreYapellidos.getText().toString();
                    state.tabSelected = currentTab;
                    //if(model.comprobarQueNoEstaEmail(email) == true){
                    // model.guardarEnBaseDeDatos(email);
                    // view.get().navigateToMenuActivity();
                    //}else{ view.get.emailYaRegistrado();}
                }
                break;
            case 1:
                if(nombreYapellidos == null || contraseña == null || numMovil == null){
                    view.get().faltanCamposPorRellenar();
                }else{
                    state.contraseña = contraseña.getText().toString();
                    state.numeroDeMovil = numMovil.getText().toString();
                    state.nombreYapellidos = nombreYapellidos.getText().toString();
                    state.tabSelected = currentTab;
                    //if(model.comprobarQueNoEstaNumMovil(email) == true){
                    // model.guardarEnBaseDeDatos(numMovil);
                    // view.get().navigateToMenuActivity();
                    //}else{ view.get.numeroDeMovilYaRegistrado();}
                }
                break;
        }


        //TODO pendiente
        //comprobar tab
        //si todos los campos estan rellenos (si no, view faltan campos) voy al modelo y chequeo que no este repe
        //si esta repe llamo a view repetido
        //si no esta llamo al modelo y guardo datos
        //mediador set contraseña/email ¡¡¡¡NO!!!! PORQUE EL mediador tiene el estado
        //llamo a view y voy al menu
    }

    @Override
    public void injectView(WeakReference<RegistrarseContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(RegistrarseContract.Model model) {
        this.model = model;
    }

}
