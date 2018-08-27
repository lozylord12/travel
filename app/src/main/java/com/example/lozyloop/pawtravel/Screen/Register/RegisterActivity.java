package com.example.lozyloop.pawtravel.Screen.Register;


import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lozyloop.pawtravel.R;



public class RegisterActivity extends AppCompatActivity {

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
    }



    public void init(){
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





}
