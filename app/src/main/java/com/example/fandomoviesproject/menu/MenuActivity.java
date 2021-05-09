package com.example.fandomoviesproject.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fandomoviesproject.R;

public class MenuActivity
        extends AppCompatActivity implements MenuContract.View {

    public static String TAG = MenuActivity.class.getSimpleName();

    private MenuContract.Presenter presenter;
    Button moviesButton, seriesButton, documentaryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        //getSupportActionBar().setTitle(R.string.app_name);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);

        moviesButton = findViewById(R.id.moviesButton);
        seriesButton = findViewById(R.id.seriesButton);
        documentaryButton = findViewById(R.id.documentaryButton);

        moviesButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                presenter.moviesButtonClicked();
            }
        });

        seriesButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                presenter.seriesButtonClicked();
            }
        });

        documentaryButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                presenter.documentaryButtonClicked();
            }
        });


   // if(savedInstanceState == null) {
    //  AppMediator.resetInstance();
   // }


        // do the setup
        MenuScreen.configure(this);

        //if (savedInstanceState == null) {
          //  super.onStart();

        //} else {
          //  presenter.onRestart();
        //}


    }

    @Override
    protected void onResume(){
        super.onResume();

        // load the data
        //presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        //presenter.onPause();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        //presenter.onBackPressed();
    }





    @Override
    protected void onDestroy() {
        super.onDestroy();

        //presenter.onDestroy();
    }



    /*@Override
    public void onDataUpdated(MenuViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
    */



    @Override
    public void navigateToMoviesScreen() {
        Intent intent = new Intent(this, com.example.fandomoviesproject.categoriasPelis.CategoryListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(MenuContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
