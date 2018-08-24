package com.example.lozyloop.pawtravel.Register;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lozyloop.pawtravel.R;

public class RegisterActivity extends AppCompatActivity {

    private ViewPager mPager;
    private int[] layouts = {R.layout.slide1,R.layout.slide2,R.layout.slide3,R.layout.slide4};
    private MpagerAdapter mpagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
    }

    public void init(){
        mPager = findViewById(R.id.view_pager);
        mpagerAdapter = new MpagerAdapter(layouts,this);
        mPager.setAdapter(mpagerAdapter);
    }
}
