package com.example.fandomoviesproject.mainActivity;

import android.text.Editable;
import android.util.Log;
import android.widget.TextView;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.data.User;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
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
        if((numMoviloEmail.toString().length() >1) && (contraseña.toString().length() > 1)) {
            state.contraseña = contraseña.getText().toString();
            state.numMoviloEmail = numMoviloEmail.getText().toString();
        }

            ArrayList<User> users = mediator.getUsersRegistrados();
            if (users == null) {
                view.get().credencialesIncorrectas();
            } else {
                for (int i = 0; i < users.size(); i++) {
                    if(users.get(i).getNumMovil()==null){
                        Log.e(TAG, "Buscando emails");
                        String email = users.get(i).getEmail();
                        System.out.println("email "+ email);
                        if (users.get(i).getEmail().equals(numMoviloEmail.getText().toString())
                        || users.get(i).getContraseña().equals(contraseña.toString())) {
                            Log.e(TAG, "Match email");
                            passDataToMediator(users.get(i));
                                view.get().navigateToMenuActivity();
                        }
                    }else if(users.get(i).getEmail()==null){
                        Log.e(TAG, "Buscando numsMovil");
                        if (users.get(i).getNumMovil().equals(numMoviloEmail.getText().toString()) ||
                             (users.get(i).getContraseña().equals(contraseña.toString()))) {
                            Log.e(TAG, "Match numMovil");
                            passDataToMediator(users.get(i));
                                view.get().navigateToMenuActivity();

                        }
                    }

                }
            }
    }

    private void passDataToMediator(User user) {
        mediator.setUserActual(user);
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
