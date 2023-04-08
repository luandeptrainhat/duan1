package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.example.myapplication.R;

public class SplashScreen extends AppCompatActivity {
    SharedPreferences onBoardingScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        CountDownTimer yourCountDownTimer =
                new CountDownTimer(1500,1000){

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        onBoardingScreen = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                        boolean isfirttime = onBoardingScreen.getBoolean("firstTime",true);
                        if (isfirttime){
                            SharedPreferences.Editor editor = onBoardingScreen.edit();
                            editor.putBoolean("firstTime",false);
                            editor.commit();
                            startActivity(new Intent(SplashScreen.this, quangcao.class));
                            finish();
                        }else {
                            startActivity(new Intent(SplashScreen.this, MainKhach.class));
                            finish();
                        }

                    }
                }.start();

    }
}