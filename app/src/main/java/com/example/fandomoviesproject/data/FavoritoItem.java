package com.example.fandomoviesproject.data;

import android.widget.ImageButton;
import android.widget.TextView;

public class FavoritoItem {
    private String titleFav;
    private String infoFav;
    private final int corazonNegro;
    private final int delete;

    public FavoritoItem(String title, String info, int corazonNegro, int delete) {
        this.titleFav = title;
        this.infoFav = info;
        this.corazonNegro = corazonNegro;
        this.delete = delete;
    }
    public String getTitle() {
        return titleFav;
    }
    public String getInfo() {
        return infoFav;
    }
    public int getCorazonNegro() {
        return corazonNegro;
    }
    public int getDeleteSimbolo() {
        return delete;
    }


}
