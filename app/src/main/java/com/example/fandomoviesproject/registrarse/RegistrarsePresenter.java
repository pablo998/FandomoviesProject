package com.example.fandomoviesproject.registrarse;

import android.text.Editable;
import android.widget.TextView;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.User;
import com.google.android.material.textfield.TextInputEditText;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

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
    public void onRegistrarmeEmail(TextInputEditText nombreYapellidosTypedEmail,
                                   TextInputEditText contraseñaTypedEmail, TextInputEditText emailTyped) {

        ArrayList<User> users = mediator.getUsersRegistrados();
        User userNuevo = new User(nombreYapellidosTypedEmail.toString(), contraseñaTypedEmail.toString(),
                emailTyped.toString(), null);
        if(users == null){
            users = new ArrayList<>();
            users.add(userNuevo);
            mediator.setUsersRegistrados(users);
            view.get().navigateToMenuActivity();
        }else {
            boolean estaCogido = false;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getEmail().equals(emailTyped.toString())) {
                    estaCogido = true;
                }
            }

            if (estaCogido == true) {
                view.get().emailYaRegistrado();
            } else {
                mediator.setUserRegistrado(userNuevo);
                mediator.setUserActual(userNuevo);
                view.get().navigateToMenuActivity();
            }
        }

    }

    @Override
    public void onRegistrarmeNumMovil(TextInputEditText nombreYapellidosTyped,
                                      TextInputEditText contraseñaTyped, TextInputEditText numMovilTyped) {

        ArrayList<User> users = mediator.getUsersRegistrados();
        User userNuevo = new User(nombreYapellidosTyped.toString(), contraseñaTyped.toString(),
                null, numMovilTyped.toString());
        if(users == null){
            users = new ArrayList<>();
            users.add(userNuevo);
            mediator.setUsersRegistrados(users);
        }else {
            boolean estaCogido = false;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getNumMovil().equals(numMovilTyped.toString())) {
                    estaCogido = true;
                }
            }

            if (estaCogido == true) {
                view.get().numeroDeMovilYaRegistrado();
            } else {
                mediator.setUserRegistrado(userNuevo);
                mediator.setUserActual(userNuevo);
                view.get().navigateToMenuActivity();
            }
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
    public void injectView(WeakReference<RegistrarseContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(RegistrarseContract.Model model) {
        this.model = model;
    }

}
