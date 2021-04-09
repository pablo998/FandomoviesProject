package com.example.fandomoviesproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class activity_registrate2 extends AppCompatActivity {

    TabLayout tabLayout = findViewById(R.id.tabLayout);
    ViewPager viewPager = findViewById(R.id.viewPager);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrate2);
        selectPage(2);

    }

    void selectPage(int pageIndex){
        tabLayout.setScrollPosition(pageIndex,0f,true);
        viewPager.setCurrentItem(pageIndex);
    }



}