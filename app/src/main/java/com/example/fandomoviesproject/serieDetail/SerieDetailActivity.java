package com.example.fandomoviesproject.serieDetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.SerieItem;
import com.example.fandomoviesproject.data.SerieItemCatalog;
import com.example.fandomoviesproject.serieDetail.SerieDetailContract;
import com.example.fandomoviesproject.serieDetail.SerieDetailScreen;
import com.example.fandomoviesproject.serieDetail.SerieDetailViewModel;


public class SerieDetailActivity
        extends AppCompatActivity implements SerieDetailContract.View {

    public static String TAG = SerieDetailActivity.class.getSimpleName();

    SerieDetailContract.Presenter presenter;
    Button trailerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_serie);

        Toolbar toolbar = findViewById(R.id.toolbarDetail);
        setSupportActionBar(toolbar);

        trailerButton = findViewById(R.id.button_trailerSerie);
        trailerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickTrailerButton();
            }
        });

        // Show the Up button and the title in the action bar
        ActionBar actionBarDetail = getSupportActionBar();
        if (actionBarDetail != null) {
            actionBarDetail.setDisplayHomeAsUpEnabled(true);
            actionBarDetail.setDisplayShowTitleEnabled(false);
        }

        // do the setup
        SerieDetailScreen.configure(this);

        // do some work
        presenter.fetchSerieDetailData();
    }

    @Override
    public void injectPresenter(SerieDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displaySerieDetailData(SerieDetailViewModel viewModel) {
        Log.e(TAG, "displaySerieDetailData()");

        // deal with the data
        SerieItemCatalog serie = viewModel.product;

        ((TextView) findViewById(R.id.textView_nombreSerie)).setText(serie.content);
        loadImageFromURL(findViewById(R.id.image_portada), serie.url_imagen);
        ((TextView) findViewById(R.id.textView_fechaSerie)).setText(serie.fecha);
        ((TextView) findViewById(R.id.textView_sinopsisContent)).setText(serie.sinopsis);

        ((TextView) findViewById(R.id.textView_nombre_actor1)).setText(serie.actor1);
        ((TextView) findViewById(R.id.textView_nombre_actor2)).setText(serie.actor2);
        ((TextView) findViewById(R.id.textView_nombre_actor3)).setText(serie.actor3);

        ((TextView) findViewById(R.id.textView_valoracion1)).setText(serie.valoracion1);
        ((TextView) findViewById(R.id.textView_valoracion2)).setText(serie.valoracion2);
        ((TextView) findViewById(R.id.textView_valoracion3)).setText(serie.valoracion3);


    }
    @Override
    public void navigateToURLtrailer(String URLtrailer){
        Uri uri = Uri.parse(URLtrailer); //missing 'http://' will cause crash
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
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

    private void loadImageFromURL(ImageView imageView, String imageUrl){
        RequestManager reqManager = Glide.with(imageView.getContext());
        RequestBuilder reqBuilder = reqManager.load(imageUrl);
        RequestOptions reqOptions = new RequestOptions();
        reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        reqBuilder.apply(reqOptions);
        reqBuilder.into(imageView);
    }


    @Override
    public void onBackPressed()
    {
        finish();
    }

}

