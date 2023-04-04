package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
//<<<<<<< HEAD

import android.view.View;
import android.widget.LinearLayout;


import com.example.myapplication.R;
//=======
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.R;
import com.example.myapplication.fragment.fragmentDa;
import com.example.myapplication.fragment.fragmentLeoNui;
import com.example.myapplication.fragment.fragmentTheThao;
import com.example.myapplication.fragment.fragmentThoiTrang;
//>>>>>>> parent of d947d51 (Hoàn thiện fragment lần 3)

public class MainKhach extends AppCompatActivity {


import android.widget.LinearLayout;

import com.example.myapplication.R;
import com.example.myapplication.fragment.fragmentTheThao;

public class MainKhach extends AppCompatActivity {
LinearLayout fragmentchung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainkhach);

//<<<<<<< HEAD



        LinearLayout lineartheothao = findViewById(R.id.lineartheothao);


//=======
//>>>>>>> parent of d947d51 (Hoàn thiện fragment lần 3)
        fragmentchung = findViewById(R.id.fragmentchung);

        Fragment fragment = new fragmentTheThao();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
//<<<<<<< HEAD
//
//=======
//>>>>>>> parent of d947d51 (Hoàn thiện fragment lần 3)


        hienfragment();


    }

    private void hienfragment() {
        LinearLayout lineartheothao = findViewById(R.id.lineartheothao);
        LinearLayout linearthoitrang = findViewById(R.id.linearthoitrang);
        LinearLayout linearda = findViewById(R.id.linearda);
        LinearLayout linearleonui = findViewById(R.id.linearleonui);



        linearda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentchung = findViewById(R.id.fragmentchung);
                Fragment fragment = new fragmentDa();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
            }
        });
        linearthoitrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentchung = findViewById(R.id.fragmentchung);
                Fragment fragment = new fragmentThoiTrang();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
            }
        });
        lineartheothao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentchung = findViewById(R.id.fragmentchung);
                Fragment fragment = new fragmentTheThao();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
            }
        });
        linearleonui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentchung = findViewById(R.id.fragmentchung);
                Fragment fragment = new fragmentLeoNui();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
            }
        });
//<<<<<<< HEAD
//
//=======
//>>>>>>> parent of d947d51 (Hoàn thiện fragment lần 3)
    }
}