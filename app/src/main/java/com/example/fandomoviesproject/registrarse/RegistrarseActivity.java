package com.example.fandomoviesproject.registrarse;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fandomoviesproject.ayuda.AyudaContract;
import com.example.fandomoviesproject.ayuda.AyudaScreen;
import com.example.fandomoviesproject.buscarDocus.DocusBuscarActivity;
import com.example.fandomoviesproject.categoriasDocu.CategoryDocuListActivity;
import com.google.android.material.tabs.TabItem;
import com.example.fandomoviesproject.R;
import com.google.android.material.textfield.TextInputEditText;


public class RegistrarseActivity extends AppCompatActivity implements RegistrarseContract.View{

    public static String TAG = RegistrarseActivity.class.getSimpleName();

    RegistrarseContract.Presenter presenter;

    TextInputEditText nombreYapellidosTyped;
    TextInputEditText contraseñaTyped;

    TextInputEditText nombreYapellidosTypedEmail;
    TextInputEditText contraseñaTypedEmail;

    TextInputEditText emailTyped;
    TextInputEditText numMovilTyped;
    private int tabSelected;

    private Context context = this;
    private TabHost tabHost;
    Button tengoCuenta, registrarmeEmail, registrarmeNumMovil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        tengoCuenta = findViewById(R.id.botonIniciaSesion);
        registrarmeEmail = findViewById(R.id.botonRegistrarmeEmail);
        registrarmeNumMovil = findViewById(R.id.botonRegistrarmeNumMovil);

        nombreYapellidosTyped = findViewById(R.id.nombreYapellidos);
        contraseñaTyped = findViewById(R.id.inputPassword);

        nombreYapellidosTypedEmail = findViewById(R.id.nombreYapellidosEmail);
        contraseñaTypedEmail = findViewById(R.id.inputPasswordEmail);

        emailTyped = findViewById(R.id.InputEmail);
        numMovilTyped = findViewById(R.id.InputNumeroMovil);

        nombreYapellidosTypedEmail.addTextChangedListener(filterTextWatcher);
        nombreYapellidosTyped.addTextChangedListener(filterTextWatcher);
        contraseñaTypedEmail.addTextChangedListener(filterTextWatcherPassword);
        contraseñaTyped.addTextChangedListener(filterTextWatcherPassword);
        emailTyped.addTextChangedListener(filterTextWatcherEmail);
        numMovilTyped.addTextChangedListener(filterTextWatcherNumMovil);

        tabHost = findViewById(R.id.tabHostRegistro);
        tabHost.setup();
        setUpTabs();

        tabHost.setOnTabChangedListener(tabChanged);
        registrarmeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = tabHost.getCurrentTab();
                if(tab == 0){
                    if((nombreYapellidosTypedEmail.getText().toString().length() > 1) &&
                            (contraseñaTypedEmail.getText().toString().length() > 1) &&
                            (emailTyped.getText().toString().length() > 1)){
                        Log.e(TAG, "Campos rellenados email");
                        presenter.onRegistrarmeEmail(nombreYapellidosTypedEmail, contraseñaTypedEmail, emailTyped);
                    }else{
                        Log.e(TAG, "Campos no rellenados email");
                        faltanCamposPorRellenar();
                    }
                }
            }
        });

        registrarmeNumMovil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = tabHost.getCurrentTab();
                if(tab ==1){
                    if((nombreYapellidosTyped.getText().toString().length() > 1)
                            && (contraseñaTyped.getText().toString().length() > 1) &&
                            (numMovilTyped.getText().toString().length() > 1)){
                        Log.e(TAG, "Campos rellenados numMovil");
                        presenter.onRegistrarmeNumMovil(nombreYapellidosTyped, contraseñaTyped, numMovilTyped);
                    }else{
                        Log.e(TAG, "Campos no rellenados numMovil");
                        faltanCamposPorRellenar();
                    }
                }
            }
        });

        //do the setup
        RegistrarseScreen.configure(this);

        if(savedInstanceState != null){
            presenter.updateView();
        }
    }

    private void setUpTabs() {
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tab1");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Email");

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("Número de móvil");

        tabHost.addTab(tabSpec);
        tabHost.addTab(tabSpec2);

        tabHost.setCurrentTab(0);
    }


    private TabHost.OnTabChangeListener tabChanged = new TabHost.OnTabChangeListener() {

        @Override
        public void onTabChanged(String tabId) {
            presenter.onTabChanged(tabId);
        }
    };

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

    private TextWatcher filterTextWatcherNumMovil = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            presenter.numMovilChanged((Editable) s);

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            presenter.numMovilChanged(s);

        }
    };

    private TextWatcher filterTextWatcherEmail = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            presenter.emailChanged((Editable) s);

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            presenter.emailChanged(s);

        }
    };


    @Override
    public void navigateToMenuActivity() {
        Toast.makeText(context,R.string.registradoConExito, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,com.example.fandomoviesproject.menu.MenuActivity.class);
        startActivity(intent);
    }

    @Override
    public void faltanCamposPorRellenar() {
        new AlertDialog.Builder(context)
                .setTitle(R.string.camposporRellenarTitle)
                .setMessage(R.string.camposporRellenar)

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
    public void emailYaRegistrado() {
        new AlertDialog.Builder(context)
                .setTitle(R.string.emailYaEnUsoTitle)
                .setMessage(R.string.emailYaEnUso)

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
    public void numeroDeMovilYaRegistrado() {
        new AlertDialog.Builder(context)
                .setTitle(R.string.numMovilYaEnUsoTitle)
                .setMessage(R.string.numMovilYaEnUso)

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
    public void updateNumeroDeMovil(String numeroMovil){
        this.numMovilTyped.setText(numeroMovil);
    }

    @Override
    public void updatePassword(String password){
        this.contraseñaTyped.setText(password);
    }

    @Override
    public void updateEmail(String email){
        this.emailTyped.setText(email);
    }

    @Override
    public void updateNombreYapellidos(String nombreYapellidos){
        this.nombreYapellidosTyped.setText(nombreYapellidos);
    }

    @Override
    public void updateTab(int currentTab){
        tabHost.setCurrentTab(currentTab);
    }


    public void backToIniciarSesion(View view) {
        finish();
    }

    @Override
    public void injectPresenter(RegistrarseContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
