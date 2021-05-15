package com.example.fandomoviesproject.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        moviesButton = findViewById(R.id.moviesButton);
        seriesButton = findViewById(R.id.seriesButton);
        documentaryButton = findViewById(R.id.documentaryButton);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.menu);
        }

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
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu: this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }


    // Determines if Action bar item was selected. If true then do corresponding action.
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        // handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.searchTool:
                startActivity(new Intent(this, com.example.fandomoviesproject.buscarPelis.PelisBuscarActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
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
    public void navigateToSeriesScreen() {
        Intent intent = new Intent(this, com.example.fandomoviesproject.categoriasSeries.CategorySerieListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(MenuContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void navigateToDocuScreen() {
        Intent intent = new Intent(this, com.example.fandomoviesproject.categoriasDocu.CategoryDocuListActivity.class);
        startActivity(intent);
    }

}
