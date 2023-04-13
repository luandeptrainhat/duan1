package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.WindowManager;

import com.example.myapplication.R;

public class Splash_Screen_new extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_new);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_Screen_new.this,dangnhap.class));
                finish();
            }
        },4500);
    }
    }
