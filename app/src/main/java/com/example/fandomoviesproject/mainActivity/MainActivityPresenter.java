package com.example.fandomoviesproject.mainActivity;

import android.text.Editable;
import android.widget.TextView;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.ComprasItem;
import com.example.fandomoviesproject.data.FavoritoItem;
import com.example.fandomoviesproject.data.SerieItem;
import com.example.fandomoviesproject.registrarse.RegistrarseContract;

import java.lang.ref.WeakReference;
//import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


public class MainActivityPresenter implements MainActivityContract.Presenter {

    public static String TAG = MainActivityPresenter.class.getSimpleName();

    private WeakReference<MainActivityContract.View> view;
    private MainActivityState state;
    private MainActivityContract.Model model;
    private AppMediator mediator;


    public MainActivityPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getMainActivityState();
    }

    @Override
    public void updateView(){
        if(state.numMoviloEmail != null){
            view.get().updateEmailoNumMovil(state.numMoviloEmail);
        }
        if(state.contraseña != null){
            view.get().updatePassword(state.contraseña);
        }
    }

    @Override
    public void textChanged(Editable text){
        state.numMoviloEmail = text.toString();
    }

    @Override
    public void passwordChanged(Editable password){
        state.contraseña = password.toString();
    }

    @Override
    public void onIniciarSesionButtonClick(TextView numMoviloEmail, TextView contraseña){
        if(numMoviloEmail != null && contraseña != null){
            state.contraseña = contraseña.getText().toString();
            state.numMoviloEmail = numMoviloEmail.getText().toString();

            //if(model.comprobarQueNoEstaEmail(email) == true ||
            //    model.comprobarQueNoEstaNumMovil(email) == true){
            // view.get().navigateToMenuActivity();
            //}else{ view.get.credencialesIncorrectas();}
        }
    }

    @Override
    public void onRegistrateButtonClick(){
        view.get().navigateToRegistrarseActivity();
    }

    @Override
    public void injectView(WeakReference<MainActivityContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(MainActivityContract.Model model) {
        this.model = model;
    }

}
