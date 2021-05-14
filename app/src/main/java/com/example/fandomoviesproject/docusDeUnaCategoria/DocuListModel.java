package com.example.fandomoviesproject.docusDeUnaCategoria;

import android.util.Log;

import com.example.fandomoviesproject.data.DocuItemCatalog;
import com.example.fandomoviesproject.data.SerieItemCatalog;

import java.util.ArrayList;
import java.util.List;

public class DocuListModel implements DocuListContract.Model {

    public static String TAG = DocuListModel.class.getSimpleName();

    private final List<DocuItemCatalog> itemList = new ArrayList<>();
    private final int COUNT = 20;

    public DocuListModel() {

    }

    @Override
    public void createItemList (int idReceived){
        // Add some sample items
        for (int index = 1; index <= COUNT; index++) {
            addProduct(createProduct(index, idReceived));
        }
    }

    @Override
    public List<DocuItemCatalog> fetchDocuListData() {
        Log.e(TAG, "fetchDocuListData()");
        return itemList;
    }

    private void addProduct(DocuItemCatalog item) {
        itemList.add(item);
    }

    private DocuItemCatalog createProduct(int position, int idReceived) {
        String content = "DOCUMENTAL " + idReceived + "." + position;

        return new DocuItemCatalog(
                position, content, fetchDocuDetails(position,idReceived)
        );

    }



    private String fetchDocuDetails(int position, int idReceived) {
        String content = "Documental " + idReceived + "." + position;
        StringBuilder builder = new StringBuilder();
        builder.append(content);

       /* for (int index = 0; index < position; index++) {
            builder.append("\nMore details information here.");
        }

        */

        return builder.toString();
    }
}