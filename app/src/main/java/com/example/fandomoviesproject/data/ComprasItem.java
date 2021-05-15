package com.example.fandomoviesproject.data;

public class ComprasItem {
    private String titleFav;
    private String infoFav;
    private final int carro;

    public ComprasItem(String title, String info, int carro) {
        this.titleFav = title;
        this.infoFav = info;
        this.carro = carro;
    }
    public String getTitle() {
        return titleFav;
    }
    public String getInfo() {
        return infoFav;
    }
    public int getCarroImage() {
        return carro;
    }


}
