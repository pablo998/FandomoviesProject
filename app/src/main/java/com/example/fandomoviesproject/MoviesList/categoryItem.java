package com.example.fandomoviesproject.MoviesList;

import java.util.ArrayList;
import java.util.List;

public class categoryItem extends catalogItem {

        public final List<categoryItem> items;

        public categoryItem(int id, String content){
            super(id, content);
            items = new ArrayList<>();
        }

        @Override
        public String toString(){
            return super.toString();
        }


}


