package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.R;
import com.example.myapplication.fragment.fragmentDa;
import com.example.myapplication.fragment.fragmentLeoNui;
import com.example.myapplication.fragment.fragmentTheThao;
import com.example.myapplication.fragment.fragmentThoiTrang;

public class MainKhach extends AppCompatActivity {
    LinearLayout fragmentchung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainkhach);

        fragmentchung = findViewById(R.id.fragmentchung);
        Fragment fragment = new fragmentTheThao();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
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
    }
}