package com.example.fandomoviesproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolderDatos> {

    ArrayList<String> listDates;

    public MoviesAdapter(ArrayList<String> listDates) {
        this.listDates = listDates;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list,null,false);
        return new ViewHolderDatos(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(listDates.get(position));

    }

    @Override
    public int getItemCount() {
        return listDates.size();
    }

    public class  ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView data;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            data = (TextView) itemView.findViewById(R.id.idTextView);
        }

        public void asignarDatos(String dates) {
            data.setText(dates);
        }
    }
}
