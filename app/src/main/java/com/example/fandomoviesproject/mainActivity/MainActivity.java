package com.example.fandomoviesproject.mainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.registrarse.RegistrarseContract;
import com.example.fandomoviesproject.registrarse.RegistrarseScreen;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    MainActivityContract.Presenter presenter;

    TextInputEditText numMoviloEmailTyped;
    TextInputEditText contraseña;
    Button iniciarSesion, botonRegistrate;

    private Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numMoviloEmailTyped = findViewById(R.id.inputEmailoNumMovil);
        contraseña = findViewById(R.id.inputPassword);

        iniciarSesion = findViewById(R.id.botonIniciarSesion);
        botonRegistrate = findViewById(R.id.botonRegistrate);

        numMoviloEmailTyped.addTextChangedListener(filterTextWatcher);
        contraseña.addTextChangedListener(filterTextWatcherPassword);

        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onIniciarSesionButtonClick(numMoviloEmailTyped,contraseña);
            }
        });

        botonRegistrate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onRegistrateButtonClick();
            }
        });


        //do the setup
        MainActivityScreen.configure(this);

        if(savedInstanceState != null){
            presenter.updateView();
        }

    }

    private TextWatcher filterTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            presenter.textChanged((Editable) s);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            presenter.textChanged(s);

        }
    };

    private TextWatcher filterTextWatcherPassword = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            presenter.passwordChanged((Editable) s);

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            presenter.passwordChanged(s);

        }
    };

    public void navigateToMenuActivity() {
        Toast.makeText(context,R.string.iniciadoCorrecto, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,com.example.fandomoviesproject.menu.MenuActivity.class);
        startActivity(intent);
    }

    public void navigateToRegistrarseActivity() {
        Intent intent = new Intent(this,com.example.fandomoviesproject.registrarse.RegistrarseActivity.class);
        startActivity(intent);
    }

    @Override
    public void credencialesIncorrectas() {
        new AlertDialog.Builder(context)
                .setTitle(R.string.credencialesIncorrectasTitle)
                .setMessage(R.string.credencialesIncorrectas)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(R.string.siWarning, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with operation
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .show();
    }

    @Override
    public void updateEmailoNumMovil(String  emailoNumMovil){
        this.numMoviloEmailTyped.setText(emailoNumMovil);
    }


    @Override
    public void updatePassword(String  password){
        this.contraseña.setText(password);
    }


    @Override
    public void injectPresenter(MainActivityContract.Presenter presenter) {
        this.presenter = presenter;
    }

}