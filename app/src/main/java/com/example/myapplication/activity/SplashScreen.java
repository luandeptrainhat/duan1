package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.example.myapplication.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        CountDownTimer yourCountDownTimer =
        new CountDownTimer(1500,1000){

            @Override
            public void onTick(long millisUntilFinished) {
//
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashScreen.this, quangcao.class));

            }
        }.start();

        SharedPreferences sharedPreferences = getSharedPreferences("THONGTIN",MODE_PRIVATE);
        String a = sharedPreferences.getString("taikhoan","");
        if (a != null){
            startActivity(new Intent(SplashScreen.this,MainKhach.class));

        }

//        yourCountDownTimer.cancel();
    }
}