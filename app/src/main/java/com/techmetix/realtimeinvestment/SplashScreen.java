package com.techmetix.realtimeinvestment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_SCREEN=5000;
    Animation topAnim,bottomAnim;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageView=findViewById(R.id.rti_logo);
        textView=findViewById(R.id.rti_text);

        imageView.setAnimation(topAnim);
        textView.setAnimation(bottomAnim);
        new Handler().postDelayed(new Runnable() {
            public void run(){
                Intent intent = new Intent(SplashScreen.this, MobileNoEntry.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

        /*Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(2*1000);

                    Intent intent = new Intent(SplashScreen.this,AccountStep2Activity.class);
                    startActivity(intent);


                    // After 5 seconds redirect to another intent


                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();*/
    }


    }

