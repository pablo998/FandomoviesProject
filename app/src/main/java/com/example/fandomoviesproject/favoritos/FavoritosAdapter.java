package com.example.fandomoviesproject.favoritos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.buscarPelis.PelisBuscarActivity;
import com.example.fandomoviesproject.data.FavoritoItem;
import com.example.fandomoviesproject.data.PeliculaItem;

import java.util.ArrayList;
import java.util.Collection;


public class FavoritosAdapter
        extends RecyclerView.Adapter<FavoritosAdapter.FavViewHolder> {

    private ArrayList<FavoritoItem> favoritosList;

    private LayoutInflater mInflater;
    private Context mContext;

    public FavoritosAdapter(Context context , ArrayList<FavoritoItem> favoritosList){
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.favoritosList = favoritosList;
    }


    class FavViewHolder extends RecyclerView.ViewHolder {
        private ImageView corazonNegro;
        private ImageButton delete;
        private TextView mTitleText;
        private TextView mInfoText;

        public FavViewHolder(View itemView, FavoritosAdapter adapter){
            super(itemView);

            // Initialize
            mTitleText = itemView.findViewById(R.id.tituloFav);
            mInfoText = itemView.findViewById(R.id.directorypublicacionFav);
            corazonNegro = itemView.findViewById(R.id.logoFav);
            delete = itemView.findViewById(R.id.deleteFavButton);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(mContext)
                            .setTitle(R.string.eliminarFavTitle)
                            .setMessage(R.string.eliminarFav)

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(R.string.siDelete, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with delete operation
                                    if (mContext instanceof FavoritosActivity) {
                                        ((FavoritosActivity)mContext).onClickDeleteButton(mTitleText, mInfoText);
                                    }
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(R.string.no, null)
                            .setIcon(R.drawable.delete)
                            .show();
                }

            });

        }

        void bindTo(FavoritoItem mCurrent) {
            mTitleText.setText(mCurrent.getTitle());
            mInfoText.setText(mCurrent.getInfo());

            // Load images into ImageView using Glide
            Glide.with(mContext)
                    .load(mCurrent.getCorazonNegro())
                    .into(corazonNegro);
            Glide.with(mContext)
                    .load(mCurrent.getDeleteSimbolo())
                    .into(delete);

        }

       /* @Override
        public void onClick(View view){
            // Get position of item that was clicked
            int mPosition = getLayoutPosition();
            // Use it to access selected item in word list
            LinearLayout element = mDocuList.get(mPosition);
            // Change word in word list
            mWordList.set(mPosition, "Clicked! " + element);
            // Notify adapter so it updates RecyclerView to show updated data
            mAdapter.notifyDataSetChanged();
        }
        */
    }


    @Override
    public FavViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View mItemView = mInflater.inflate(
                R.layout.activity_favoritosfila,parent,false);
        return new FavViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(FavViewHolder holder,int position) {
        FavoritoItem mCurrent= favoritosList.get(position);
        holder.bindTo(mCurrent);
    }

    @Override
    public int getItemCount() {
        return favoritosList.size();
    }


}
