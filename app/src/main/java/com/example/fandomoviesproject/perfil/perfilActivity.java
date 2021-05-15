package com.example.fandomoviesproject.perfil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fandomoviesproject.R;

public class perfilActivity
        extends AppCompatActivity implements perfilContract.View {

    public static String TAG = perfilActivity.class.getSimpleName();

    private perfilContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miperfil);
        getSupportActionBar().setTitle(R.string.app_name);

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        perfilScreen.configure(this);

        //if (savedInstanceState == null) {
       //     presenter.onStart();

        //} else {
         //   presenter.onRestart();
        //}
    }

    /*
    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        presenter.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }

    @Override
    public void onDataUpdated(perfilViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, perfilActivity.class);
        startActivity(intent);
    }
    */


    @Override
    public void injectPresenter(perfilContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
