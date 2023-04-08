package com.example.myapplication.activity;

import static android.view.Gravity.CENTER;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.SerchAdapter;
import com.example.myapplication.dao.SerchDao;
import com.example.myapplication.fragment.fragmentDa;
import com.example.myapplication.fragment.fragmentLeoNui;
import com.example.myapplication.fragment.fragmentTheThao;
import com.example.myapplication.fragment.fragmentThoiTrang;
import com.example.myapplication.model.Product;

import java.util.ArrayList;


public class MainKhach extends AppCompatActivity {
    LinearLayout fragmentchung;
    private Context context;
    TextView searchView;
    RecyclerView recyclerView;
    SerchDao serchDao;
    SerchAdapter serchAdapter;
    ArrayList<Product> list;
// dung da o day roi



    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainkhach);
        recyclerView = findViewById(R.id.recycleview1);
        recyclerView.setVisibility(View.GONE);
        list = new ArrayList<>();
        serchDao = new SerchDao(this);
        getDSSerch();
        searchView = findViewById(R.id.edtserch);

       searchView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MainKhach.this,Serch.class));
           }
       });

//        searchView.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                recyclerView.setVisibility(View.VISIBLE);
//                MainKhach.this.serchAdapter.getFilter().filter(s);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//
//        });


        LinearLayout lineartheothao = findViewById(R.id.lineartheothao);
        fragmentchung = findViewById(R.id.fragmentchung);
        Fragment fragment = new fragmentTheThao();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
        lineartheothao.setBackground(getDrawable(R.drawable.shapemain2));


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
                Set();
                SetColer(linearda);

            }


        });
        linearthoitrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentchung = findViewById(R.id.fragmentchung);
                Fragment fragment = new fragmentThoiTrang();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
                Set();
                SetColer(linearthoitrang);
            }
        });
        lineartheothao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentchung = findViewById(R.id.fragmentchung);
                Fragment fragment = new fragmentTheThao();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
                Set();
                SetColer(lineartheothao);
            }
        });
        linearleonui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentchung = findViewById(R.id.fragmentchung);
                Fragment fragment = new fragmentLeoNui();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
                Set();
                SetColer(linearleonui);
            }
        });
    }

    private void SetColer(LinearLayout linearLayout) {
        linearLayout.setBackground(getDrawable(R.drawable.shapemain2));
        //  linearLayout.setLayoutParams(new LinearLayout.LayoutParams(130, 65));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(CENTER);
        //  linearLayout.setPadding(5, 5, 5, 5);

        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View v = linearLayout.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTextColor(Color.WHITE);
                ((TextView) v).setTextSize(10);

            }

        }
    }

    private void Set() {
        LinearLayout lineartheothao = findViewById(R.id.lineartheothao);
        LinearLayout linearthoitrang = findViewById(R.id.linearthoitrang);
        LinearLayout linearda = findViewById(R.id.linearda);
        LinearLayout linearleonui = findViewById(R.id.linearleonui);

        lineartheothao.setBackground(getDrawable(R.drawable.shapemain3));
        linearthoitrang.setBackground(getDrawable(R.drawable.shapemain3));
        linearda.setBackground(getDrawable(R.drawable.shapemain3));
        linearleonui.setBackground(getDrawable(R.drawable.shapemain3));

        for (int i = 0; i < lineartheothao.getChildCount(); i++) {
            View v = lineartheothao.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTextColor(Color.BLACK);
                ((TextView) v).setTextSize(7);
            }

        }
        for (int i = 0; i < linearthoitrang.getChildCount(); i++) {
            View v = linearthoitrang.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTextColor(Color.BLACK);
                ((TextView) v).setTextSize(7);
            }

        }
        for (int i = 0; i < linearda.getChildCount(); i++) {
            View v = linearda.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTextColor(Color.BLACK);
                ((TextView) v).setTextSize(7);
            }

        }
        for (int i = 0; i < linearleonui.getChildCount(); i++) {
            View v = linearleonui.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTextColor(Color.BLACK);
                ((TextView) v).setTextSize(7);
            }

        }

        lineartheothao.setOrientation(LinearLayout.VERTICAL);
        linearthoitrang.setOrientation(LinearLayout.VERTICAL);
        linearda.setOrientation(LinearLayout.VERTICAL);
        linearleonui.setOrientation(LinearLayout.VERTICAL);

    }
    private void getDSSerch(){
        list = serchDao.getDS();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainKhach.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        serchAdapter = new SerchAdapter(this,list,serchDao);
        recyclerView.setAdapter(serchAdapter);

    }

}