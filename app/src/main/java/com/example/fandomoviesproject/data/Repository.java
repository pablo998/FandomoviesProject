package com.example.fandomoviesproject.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.room.Room;

import com.example.fandomoviesproject.database.CategoryPeliDao;
import com.example.fandomoviesproject.database.FandomoviesDatabase;
import com.example.fandomoviesproject.database.PeliCategoryDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;




public class Repository implements RepositoryContract {

    public static String TAG = Repository.class.getSimpleName();


    public static final String DB_FILE = "catalog.db";
    public static final String JSON_FILESSERIES = "catalogSeries.json";
    public static final String JSON_ROOTseries = "categoriesSeries";

    public static final String JSON_FILESPELIS = "catalogPelis.json";
    public static final String JSON_ROOTpelis = "categoriesPelis";

    public static final String JSON_FILESDOCUS = "catalogDocus.json";
    public static final String JSON_ROOTdocus = "categoriesDocumentales";


    private static Repository INSTANCE;

    private FandomoviesDatabase database;
    private Context context;


    public static RepositoryContract getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Repository(context);
        }

        return INSTANCE;
    }

    private Repository(Context context) {
        this.context = context;

        database = Room.databaseBuilder(
                context, FandomoviesDatabase.class, DB_FILE
        ).fallbackToDestructiveMigration().build();

    }

    @Override
    public void loadCatalogPeli(
            final boolean clearFirst, final FetchCatalogDataPeliCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (clearFirst) {
                    database.clearAllTables();
                }

                boolean error = false;
                if (getCategoryPeliDao().loadCategoriesPeli().size() == 0) {
                    error = !loadCatalogPeliFromJSON(loadJSONPeliFromAsset());
                }

                if (callback != null) {
                    callback.onCatalogDataPeliFetched(error);
                }
            }
        });

    }

    @Override
    public void getPelisList(
            final CategoryItemCatalog category, final GetPelisListCallback callback) {

        getPelisList(category.id, callback);
    }


    @Override
    public void getPelisList(
            final int categoryId, final GetPelisListCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setPelisList(getPeliCategoryDao().loadPelis(categoryId));
                }
            }
        });

    }


    @Override
    public void getPeli(final int id, final GetPeliCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setPeli(getPeliCategoryDao().loadPeli(id));
                }
            }
        });
    }

    @Override
    public void getCategoryPeli(final int id, final GetCategoryPeliCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setCategoryPeli(getCategoryPeliDao().loadCategoryPeli(id));
                }
            }
        });

    }

    @Override
    public void getCategoryPeliList(final GetCategoryPeliListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setCategoryPeliList(getCategoryPeliDao().loadCategoriesPeli());
                }
            }
        });

    }

    @Override
    public void deletePeli(
            final PeliculaItemCatalog peli, final DeletePeliCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    getPeliCategoryDao().deletePeli(peli);
                    callback.onPeliDeleted();
                }
            }
        });
    }

    @Override
    public void updatePeli(
            final PeliculaItemCatalog peli, final UpdatePeliCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    getPeliCategoryDao().updatePeli(peli);
                    callback.onPeliUpdated();
                }
            }
        });
    }


    @Override
    public void deleteCategoryPeli(
            final CategoryItemCatalog category, final DeleteCategoryPeliCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    getCategoryPeliDao().deleteCategoryPeli(category);
                    callback.onCategoryPeliDeleted();
                }
            }
        });
    }

    @Override
    public void updateCategoryPeli(
            final CategoryItemCatalog category, final UpdateCategoryPeliCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    getCategoryPeliDao().updateCategoryPeli(category);
                    callback.onCategoryPeliUpdated();
                }
            }
        });
    }


    private CategoryPeliDao getCategoryPeliDao() {
        return database.categoryPeliDao();
    }

    private PeliCategoryDao getPeliCategoryDao() {
        return database.peliCategoryDao();
    }


    private boolean loadCatalogPeliFromJSON(String json) {
        Log.e(TAG, "loadCatalogPeliFromJSON()");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOTpelis);

            if (jsonArray.length() > 0) {

                final List<CategoryItemCatalog> categories = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), CategoryItemCatalog[].class)
                );

                for (CategoryItemCatalog category : categories) {
                    getCategoryPeliDao().insertCategory(category);
                }

                for (CategoryItemCatalog category : categories) {
                    for (PeliculaItemCatalog product : category.items) {
                        product.categoryId = category.id;
                        getPeliCategoryDao().insertProductPeli(product);
                    }
                }

                return true;
            }

        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }

        return false;
    }

    private String loadJSONPeliFromAsset() {
        //Log.e(TAG, "loadJSONFromAsset()");

        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_FILESPELIS);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException error) {
            Log.e(TAG, "error: " + error);
        }

        return json;
    }
}