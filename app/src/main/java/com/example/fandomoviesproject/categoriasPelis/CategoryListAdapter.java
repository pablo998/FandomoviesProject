package com.example.fandomoviesproject.categoriasPelis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.categoriasSeries.CategorySerieListAdapter;
import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    private List<CategoryItemCatalog> itemList;
    private final View.OnClickListener clickListener;


    public CategoryListAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
    }


    public void addItem(CategoryItemCatalog item){
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<CategoryItemCatalog> items){
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<CategoryItemCatalog> items){
        itemList = items;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public CategoryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_categorias_de_peliculaslista_content, parent, false);
        return new CategoryListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CategoryListAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(itemList.get(position));
        holder.itemView.setOnClickListener(clickListener);

        holder.contentView.setText(itemList.get(position).content);

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView contentView;

        ViewHolder(View view) {
            super(view);
            contentView = view.findViewById(R.id.categoriaText);
        }
    }
}
