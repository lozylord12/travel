package com.example.lozyloop.pawtravel.Screen.ItemTravel;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.lozyloop.pawtravel.R;
import com.example.lozyloop.pawtravel.data.Adapter.CustomAdapter;

public class SlideImageActivity extends AppCompatActivity {

    CustomAdapter adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_image_hotel);

        init();
    }

    public void init(){
        viewPager = findViewById(R.id.view_pager);
        adapter = new CustomAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
