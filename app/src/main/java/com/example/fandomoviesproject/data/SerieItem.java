package com.example.fandomoviesproject.data;

public class SerieItem {
    private String title;
    private String info;
    private final int imageResourceLogo;
    private final int imageResourceLike;
    private final int imageResourceCarro;

    public SerieItem(String title, String info, int imageResourceLogo, int imageResourceLike, int imageResourceCarro) {
        this.title = title;
        this.info = info;
        this.imageResourceLogo = imageResourceLogo;
        this.imageResourceLike = imageResourceLike;
        this.imageResourceCarro = imageResourceCarro;
    }
    public String getTitle() {
        return title;
    }
    public String getInfo() {
        return info;
    }
    public int getImageResourceLogo() {
        return imageResourceLogo;
    }
    public int getImageResourceLike() {
        return imageResourceLike;
    }
    public int getImageResourceCarro() {
        return imageResourceCarro;
    }


}
