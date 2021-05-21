package com.example.fandomoviesproject.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.room.Room;

import com.example.fandomoviesproject.database.CategoryDocuDao;
import com.example.fandomoviesproject.database.CategoryPeliDao;
import com.example.fandomoviesproject.database.CategorySerieDao;
import com.example.fandomoviesproject.database.DocuCategoryDao;
import com.example.fandomoviesproject.database.FandomoviesDatabase;
import com.example.fandomoviesproject.database.PeliCategoryDao;
import com.example.fandomoviesproject.database.SerieCategoryDao;
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


        /*
    ---------------------------- DE AQUÍ HACIA ABAJO SERIES -----------------------------------------------------------
     */

    @Override
    public void loadCatalogSerie(
            final boolean clearFirst, final FetchCatalogDataSerieCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(clearFirst) {
                    database.clearAllTables();
                }

                boolean error = false;
                if(getCategorySerieDao().loadCategoriesSeries().size() == 0 ) {
                    error = !loadCatalogSerieFromJSON(loadJSONSeriesFromAsset());
                }

                if(callback != null) {
                    callback.onCatalogDataSerieFetched(error);
                }
            }
        });

    }

    @Override
    public void getSeriesList(
            final CategorySerieItemCatalog category, final GetSeriesListCallback callback) {

        getSeriesList(category.id, callback);
    }


    @Override
    public void getSeriesList(
            final int categoryId, final GetSeriesListCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setSeriesList(getSerieCategoryDao().loadSeries(categoryId));
                }
            }
        });

    }


    @Override
    public void getSerie(final int id, final GetSerieCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setSerie(getSerieCategoryDao().loadSerie(id));
                }
            }
        });
    }

    @Override
    public void getCategorySerie(final int id, final GetCategorySerieCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setCategorySerie(getCategorySerieDao().loadCategorySerie(id));
                }
            }
        });

    }

    @Override
    public void getCategorySerieList(final GetCategorySerieListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setCategorySerieList(getCategorySerieDao().loadCategoriesSeries());
                }
            }
        });

    }

    @Override
    public void deleteSerie(
            final SerieItemCatalog serie, final DeleteSerieCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getSerieCategoryDao().deleteSerie(serie);
                    callback.onSerieDeleted();
                }
            }
        });
    }

    @Override
    public void updateSerie(
            final SerieItemCatalog serie, final UpdateSerieCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getSerieCategoryDao().updateSerie(serie);
                    callback.onSerieUpdated();
                }
            }
        });
    }


    @Override
    public void deleteCategorySerie(
            final CategorySerieItemCatalog category, final DeleteCategorySerieCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getCategorySerieDao().deleteCategorySerie(category);
                    callback.onCategorySerieDeleted();
                }
            }
        });
    }

    @Override
    public void updateCategorySerie(
            final CategorySerieItemCatalog category, final UpdateCategorySerieCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getCategorySerieDao().updateCategorySerie(category);
                    callback.onCategorySerieUpdated();
                }
            }
        });
    }


    private CategorySerieDao getCategorySerieDao() {
        return database.categorySerieDao();
    }

    private SerieCategoryDao getSerieCategoryDao() {
        return database.serieCategoryDao();
    }


    private boolean loadCatalogSerieFromJSON(String json) {
        Log.e(TAG, "loadCatalogSerieFromJSON()");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOTseries);

            if (jsonArray.length() > 0) {

                final List<CategorySerieItemCatalog> categories = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), CategorySerieItemCatalog[].class)
                );

                for (CategorySerieItemCatalog category: categories) {
                    getCategorySerieDao().insertCategory(category);
                }

                for (CategorySerieItemCatalog category: categories) {
                    for (SerieItemCatalog product: category.items) {
                        product.categoryId = category.id;
                        getSerieCategoryDao().insertProduct(product);
                    }
                }

                return true;
            }

        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }

        return false;
    }

    private String loadJSONSeriesFromAsset() {
        //Log.e(TAG, "loadJSONFromAsset()");

        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_FILESSERIES);
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

    /*
    ---------------------------- DE AQUÍ HACIA ARRIBA SERIES, HACIA ABAJO PELIS -----------------------------------------
     */

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

     /*
    ---------------------------- DE AQUÍ HACIA ARRIBA PELIS, HACIA ABAJO DOCUS -----------------------------------------------------------
     */

    @Override
    public void loadCatalogDocu(
            final boolean clearFirst, final FetchCatalogDataDocuCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(clearFirst) {
                    database.clearAllTables();
                }

                boolean error = false;
                if(getCategoryDocuDao().loadCategoriesDocu().size() == 0 ) {
                    error = !loadCatalogDocuFromJSON(loadJSONDocuFromAsset());
                }

                if(callback != null) {
                    callback.onCatalogDataDocuFetched(error);
                }
            }
        });

    }

    @Override
    public void getDocusList(
            final CategoryDocuItemCatalog category, final GetDocusListCallback callback) {

        getDocusList(category.id, callback);
    }


    @Override
    public void getDocusList(
            final int categoryId, final GetDocusListCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setDocusList(getDocuCategoryDao().loadDocus(categoryId));
                }
            }
        });

    }


    @Override
    public void getDocu(final int id, final GetDocuCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setDocu(getDocuCategoryDao().loadDocu(id));
                }
            }
        });
    }

    @Override
    public void getCategoryDocu(final int id, final GetCategoryDocuCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setCategoryDocu(getCategoryDocuDao().loadCategoryDocu(id));
                }
            }
        });

    }

    @Override
    public void getCategoryDocuList(final GetCategoryDocuListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setCategoryDocuList(getCategoryDocuDao().loadCategoriesDocu());
                }
            }
        });

    }

    @Override
    public void deleteDocu(
            final DocuItemCatalog docu, final DeleteDocuCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getDocuCategoryDao().deleteDocu(docu);
                    callback.onDocuDeleted();
                }
            }
        });
    }

    @Override
    public void updateDocu(
            final DocuItemCatalog docu, final UpdateDocuCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getDocuCategoryDao().updateDocu(docu);
                    callback.onDocuUpdated();
                }
            }
        });
    }


    @Override
    public void deleteCategoryDocu(
            final CategoryDocuItemCatalog category, final DeleteCategoryDocuCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getCategoryDocuDao().deleteCategoryDocu(category);
                    callback.onCategoryDocuDeleted();
                }
            }
        });
    }

    @Override
    public void updateCategoryDocu(
            final CategoryDocuItemCatalog category, final UpdateCategoryDocuCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getCategoryDocuDao().updateCategoryDocu(category);
                    callback.onCategoryDocuUpdated();
                }
            }
        });
    }


    private CategoryDocuDao getCategoryDocuDao() {
        return database.categoryDocuDao();
    }

    private DocuCategoryDao getDocuCategoryDao() {
        return database.docuCategoryDao();
    }


    private boolean loadCatalogDocuFromJSON(String json) {
        Log.e(TAG, "loadCatalogDocuFromJSON()");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOTdocus);

            if (jsonArray.length() > 0) {

                final List<CategoryDocuItemCatalog> categories = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), CategoryDocuItemCatalog[].class)
                );

                for (CategoryDocuItemCatalog category: categories) {
                    getCategoryDocuDao().insertCategory(category);
                }

                for (CategoryDocuItemCatalog category: categories) {
                    for (DocuItemCatalog product: category.items) {
                        product.categoryId = category.id;
                        getDocuCategoryDao().insertProductDocu(product);
                    }
                }

                return true;
            }

        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }

        return false;
    }

    private String loadJSONDocuFromAsset() {
        //Log.e(TAG, "loadJSONFromAsset()");

        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_FILESDOCUS);
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
