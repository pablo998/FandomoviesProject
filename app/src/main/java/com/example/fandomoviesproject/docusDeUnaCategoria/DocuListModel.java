package com.example.fandomoviesproject.docusDeUnaCategoria;

import android.util.Log;
import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;
import com.example.fandomoviesproject.data.RepositoryContract;

public class DocuListModel implements DocuListContract.Model {

    public static String TAG = DocuListModel.class.getSimpleName();

    private RepositoryContract repository;

    public DocuListModel(RepositoryContract repository){
        this.repository = repository;
    }

    @Override
    public void fetchDocuListData(
            CategoryDocuItemCatalog category, RepositoryContract.GetDocusListCallback callback) {

        Log.e(TAG, "fetchDocusListData()");
        repository.getDocusList(category, callback);
    }
}