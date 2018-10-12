package com.example.lozyloop.pawtravel.Screen.Register;


import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lozyloop.pawtravel.R;
import com.example.lozyloop.pawtravel.Screen.Login.SigninActivity;
import com.example.lozyloop.pawtravel.data.Adapter.MpagerAdapter;


public class RegisterActivity extends AppCompatActivity {

    private Button btn_register;
    private TextView text;

    private ViewPager mPager;
    private int[] layouts = {R.layout.slide1,R.layout.slide2,R.layout.slide3,R.layout.slide4};
    private MpagerAdapter mpagerAdapter;


    private LinearLayout Dots_Layout;
    private ImageView[] dots;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        checkStatus();

        setContentView(R.layout.activity_register);

        init();
        createDots(0);
        addonPageChange();

        HandleEventOnClick();

    }



    public void init(){

        btn_register = findViewById(R.id.btn_register);
        text = findViewById(R.id.text);

        mPager = findViewById(R.id.view_pager);
        mpagerAdapter = new MpagerAdapter(layouts,this);
        mPager.setAdapter(mpagerAdapter);
        Dots_Layout = findViewById(R.id.dotsLayout);

    }

    public void checkStatus(){
        if (Build.VERSION.SDK_INT >= 19){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)  ;
        }
    }

    public void createDots(int current_position){
        if (Dots_Layout != null)
            Dots_Layout.removeAllViews();

        dots = new ImageView[layouts.length];
        for (int i = 0; i < layouts.length; i++){
            dots[i] = new ImageView(this);
            if (i == current_position){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dots_selected));
            }else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dots_default));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(4,0,4,0);

                Dots_Layout.addView(dots[i],params);
        }
    }

    public void addonPageChange(){
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void HandleEventOnClick(){
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(RegisterActivity.this, CreateActivity.class);
                startActivity(myintent);
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
    }





}
