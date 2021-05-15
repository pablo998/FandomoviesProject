package com.example.fandomoviesproject.categoriasDocu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;

import java.util.List;

public class CategoryDocuListAdapter extends ArrayAdapter<CategoryDocuItemCatalog> {

    private final List<CategoryDocuItemCatalog> itemList;
    private final View.OnClickListener clickListener;

    public CategoryDocuListAdapter(
            Context context, List<CategoryDocuItemCatalog> items, View.OnClickListener listener) {

        super(context, 0, items);

        itemList = items;
        clickListener = listener;
    }


    @Override
    public CategoryDocuItemCatalog getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        if (itemView == null) {
            itemView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.activity_categorias_de_documentaleslistacontent, parent, false);
        }

        itemView.setTag(itemList.get(position));
        itemView.setOnClickListener(clickListener);

        final TextView contentView = itemView.findViewById(R.id.docuText);
        contentView.setText(itemList.get(position).content);

        return itemView;
    }
}
