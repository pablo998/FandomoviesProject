package com.example.fandomoviesproject.peliculaDetail;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;


public class PeliculaDetailActivity
        extends AppCompatActivity implements PeliculaDetailContract.View {

    public static String TAG = PeliculaDetailActivity.class.getSimpleName();

    PeliculaDetailContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);

       Toolbar toolbar = findViewById(R.id.toolbarDetail);
       setSupportActionBar(toolbar);

        // do the setup
        PeliculaDetailScreen.configure(this);

        // do some work
        presenter.fetchPeliculaDetailData();

        // Show the Up button and the title in the action bar
        ActionBar actionBarDetail = getSupportActionBar();
        if (actionBarDetail != null) {
            actionBarDetail.setDisplayHomeAsUpEnabled(true);
            actionBarDetail.setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public void injectPresenter(PeliculaDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayPeliculaDetailData(PeliculaDetailViewModel viewModel) {
        Log.e(TAG, "displayPeliculaDetailData()");

        // deal with the data
        PeliculaItemCatalog product = viewModel.product;

        if (product != null) {
            ((TextView) findViewById(R.id.textView_nombrePelicula)).setText(product.details);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

