package com.example.fandomoviesproject.data;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


import static androidx.room.ForeignKey.CASCADE;


@Entity(
        tableName = "productsPelis",
        foreignKeys = @ForeignKey(
                entity = CategoryItemCatalog.class,
                parentColumns = "id",
                childColumns = "category_id",
                onDelete = CASCADE
        )
)
public class PeliculaItemCatalog {

    @PrimaryKey
    public int id;

    public String content;
    public String fecha;
    public String url_trailer;
    public String url_imagen;
    public String sinopsis;
    public String url_comprar;


    public String actor1;
    public String actor2;
    public String actor3;

    public String valoracion1;
    public String valoracion2;
    public String valoracion3;

    public String directorYfecha;
    public int imageResourceLike;
    public int imageResourceCarro;



    @ColumnInfo(name = "category_id")
    public int categoryId;


    @Override
    public String toString() {
        return content;
    }
}