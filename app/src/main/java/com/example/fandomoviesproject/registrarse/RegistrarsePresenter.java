package com.example.fandomoviesproject.registrarse;

import android.text.Editable;
import android.widget.TextView;

import com.example.fandomoviesproject.app.AppMediator;

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
    public void updateView(){
        if(state.numeroDeMovil != null){
            view.get().updateNumeroDeMovil(state.numeroDeMovil);
        }
        if(state.contraseña != null){
            view.get().updatePassword(state.contraseña);
        }
        if(state.email != null){
            view.get().updateEmail(state.email);
        }
        if(state.nombreYapellidos != null){
            view.get().updateNombreYapellidos(state.nombreYapellidos);
        }
        if(state.tabSelected == 1){
            view.get().updateTab(state.tabSelected);
        }
    }

    @Override
    public void onTabChanged(String tabId){
        if(tabId.equals("tab2")){
            state.tabSelected = 1;
        }else{
            state.tabSelected = 0;
        }
    }


    @Override
    public void textChanged(Editable text){
        state.nombreYapellidos = text.toString();
    }

    @Override
    public void passwordChanged(Editable password){
        state.contraseña = password.toString();
    }

    @Override
    public void numMovilChanged(Editable numMovil){
        state.numeroDeMovil = numMovil.toString();
    }

    @Override
    public void emailChanged(Editable email){
        state.email = email.toString();
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
