package com.example.fandomoviesproject.registrarse;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fandomoviesproject.ayuda.AyudaContract;
import com.example.fandomoviesproject.ayuda.AyudaScreen;
import com.example.fandomoviesproject.buscarDocus.DocusBuscarActivity;
import com.google.android.material.tabs.TabItem;
import com.example.fandomoviesproject.R;
import com.google.android.material.textfield.TextInputEditText;


public class RegistrarseActivity extends AppCompatActivity implements RegistrarseContract.View{

    RegistrarseContract.Presenter presenter;

    TextInputEditText nombreYapellidosTyped;
    TextInputEditText contraseñaTyped;

    TextInputEditText emailTyped;
    TextInputEditText numMovilTyped;
    private int tabSelected;

    private Context context = this;
    private TabHost tabHost;
    Button tengoCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        tengoCuenta = findViewById(R.id.botonIniciaSesion);

        nombreYapellidosTyped = findViewById(R.id.nombreYapellidos);
        contraseñaTyped = findViewById(R.id.inputPassword);

        emailTyped = findViewById(R.id.InputEmail);
        numMovilTyped = findViewById(R.id.InputNumeroMovil);

        tabHost = findViewById(R.id.tabHostRegistro);
        tabHost.setup();
        setUpTabs();

        //do the setup
        RegistrarseScreen.configure(this);


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


    public void onClickRegistrarme(View view) {
        tabSelected = tabHost.getCurrentTab();
        presenter.onClickRegistrarme(tabSelected, nombreYapellidosTyped, contraseñaTyped,
                numMovilTyped, emailTyped);
        /* Va comprueba que todos los campos esten rellenados y
          le pide al modelo que busque en la base de datos si hay
          un email que sea igual. Warning por pantalla si hay igual/campos no rellenados
          Si no hay igual guardo datos (los 3) en base de datos
          paso email a mediator con set. Y en otras pantallas (mi perfil y menu) lo cojo
          y busco en la base de datos
         */
    }

    @Override
    public void navigateToMenuActivity() {
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
                .setPositiveButton(R.string.siFav, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with operation
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(R.string.no, null)
                .show();
    }

    @Override
    public void emailYaRegistrado() {
        new AlertDialog.Builder(context)
                .setTitle(R.string.emailYaEnUsoTitle)
                .setMessage(R.string.emailYaEnUso)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(R.string.siFav, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with operation
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(R.string.no, null)
                .show();
    }

    @Override
    public void numeroDeMovilYaRegistrado() {
        new AlertDialog.Builder(context)
                .setTitle(R.string.numMovilYaEnUsoTitle)
                .setMessage(R.string.numMovilYaEnUso)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(R.string.siFav, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with operation
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(R.string.no, null)
                .show();
    }

    public void backToIniciarSesion(View view) {
        finish();
    }

    @Override
    public void injectPresenter(RegistrarseContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
