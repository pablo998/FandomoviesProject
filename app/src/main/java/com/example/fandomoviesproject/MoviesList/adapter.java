package com.example.fandomoviesproject.MoviesList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.fandomoviesproject.R;

import java.util.List;

public class adapter extends ArrayAdapter<catalogItem> {

    private final List<catalogItem> itemList;
    private final View.OnClickListener clickListener;


    public adapter(
            Context context, List<catalogItem> items, View.OnClickListener listener) {

        super(context, 0, items);

        itemList = items;
        clickListener = listener;
    }


    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public catalogItem getItem(int position) {
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
                    .inflate(R.layout.category_moviecontent, parent, false);
        }

        itemView.setTag(itemList.get(position));
        itemView.setOnClickListener(clickListener);

        final TextView contentView = itemView.findViewById(R.id.content);
        contentView.setText(itemList.get(position).content);

        return itemView;
    }


}

