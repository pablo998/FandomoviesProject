package com.example.fandomoviesproject.categoriasSeries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;

import java.util.List;

public class CategorySerieListAdapter extends ArrayAdapter<CategorySerieItemCatalog> {

    private final List<CategorySerieItemCatalog> itemList;
    private final View.OnClickListener clickListener;


    public CategorySerieListAdapter(
            Context context, List<CategorySerieItemCatalog> items, View.OnClickListener listener) {

        super(context, 0, items);

        itemList = items;
        clickListener = listener;
    }


    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public CategorySerieItemCatalog getItem(int position) {
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
                    .inflate(R.layout.activity_categorias_de_serieslistacontent, parent, false);
        }

        itemView.setTag(itemList.get(position));
        itemView.setOnClickListener(clickListener);

        final TextView contentView = itemView.findViewById(R.id.categoriaText);
        contentView.setText(itemList.get(position).content);

        return itemView;
    }


}

