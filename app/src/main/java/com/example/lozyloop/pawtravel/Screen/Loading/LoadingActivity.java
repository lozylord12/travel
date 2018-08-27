package com.example.lozyloop.pawtravel.Screen.Register.Loading;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.lozyloop.pawtravel.R;
import com.example.lozyloop.pawtravel.Screen.Register.RegisterActivity;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class LoadingActivity extends AppCompatActivity {

    private static int SLASH_TIME_OUT = 2500;
    private ImageView image_logo;
    private RingProgressBar ring_logo;
    private int progess = 0;
    private Handler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        init();
        RingProgress();
    }

    public void init(){
        image_logo = findViewById(R.id.image_logo);
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_center);
        image_logo.startAnimation(hyperspaceJumpAnimation);
        ring_logo = findViewById(R.id.ring_logo);
    }

    public void RingProgress(){

        ring_logo.setOnProgressListener(new RingProgressBar.OnProgressListener() {
            @Override
            public void progressToComplete() {
                Intent myintent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(myintent);
            }
        });

        myHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {

                if (msg.what == 0){
                    if (progess < 100){
                        progess++;
                        ring_logo.setProgress(progess);
                    }
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(100);
                        myHandler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start() ;
    }
}
