package com.example.fandomoviesproject.categoriasDocu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;

import java.util.ArrayList;
import java.util.List;

public class CategoryDocuListAdapter extends RecyclerView.Adapter<CategoryDocuListAdapter.ViewHolder> {

    private List<CategoryDocuItemCatalog> itemList;
    private final View.OnClickListener clickListener;


    public CategoryDocuListAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
    }


    public void addItem(CategoryDocuItemCatalog item){
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<CategoryDocuItemCatalog> items){
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<CategoryDocuItemCatalog> items){
        itemList = items;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public CategoryDocuListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_categorias_de_documentaleslistacontent, parent, false);
        return new CategoryDocuListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CategoryDocuListAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(itemList.get(position));
        holder.itemView.setOnClickListener(clickListener);

        holder.contentView.setText(itemList.get(position).content);

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView contentView;

        ViewHolder(View view) {
            super(view);
            contentView = view.findViewById(R.id.docuText);
        }
    }
}
