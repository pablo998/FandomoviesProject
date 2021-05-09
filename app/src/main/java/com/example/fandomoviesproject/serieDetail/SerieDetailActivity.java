package com.example.fandomoviesproject.serieDetail;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.SerieItemCatalog;
import com.example.fandomoviesproject.serieDetail.SerieDetailContract;
import com.example.fandomoviesproject.serieDetail.SerieDetailScreen;
import com.example.fandomoviesproject.serieDetail.SerieDetailViewModel;


public class SerieDetailActivity
        extends AppCompatActivity implements SerieDetailContract.View {

    public static String TAG = SerieDetailActivity.class.getSimpleName();

    SerieDetailContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_serie);

       Toolbar toolbar = findViewById(R.id.toolbarDetail);
       setSupportActionBar(toolbar);

        // do the setup
        SerieDetailScreen.configure(this);

        // do some work
        presenter.fetchSerieDetailData();

        // Show the Up button and the title in the action bar
        ActionBar actionBarDetail = getSupportActionBar();
        if (actionBarDetail != null) {
            actionBarDetail.setDisplayHomeAsUpEnabled(true);
            actionBarDetail.setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public void injectPresenter(SerieDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displaySerieDetailData(SerieDetailViewModel viewModel) {
        Log.e(TAG, "displaySerieDetailData()");

        // deal with the data
        SerieItemCatalog product = viewModel.product;

        if (product != null) {
            ((TextView) findViewById(R.id.textView_nombreSerie)).setText(product.details);
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


    @Override
    public void onBackPressed()
    {
        finish();
    }

}

