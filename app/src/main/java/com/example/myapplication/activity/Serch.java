package com.example.myapplication.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.adapter.SerchAdapter;
import com.example.myapplication.dao.SerchDao;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class Serch extends AppCompatActivity {
    private  Context context;
    EditText searchView;
    RecyclerView recyclerView;
      SerchDao serchDao;
      SerchAdapter serchAdapter;
      ArrayList<Product> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serch);
        recyclerView = findViewById(R.id.recycleview1);
        recyclerView.setVisibility(View.GONE);
        list = new ArrayList<>();
        serchDao = new SerchDao(this);
        getDSSerch();
        searchView = findViewById(R.id.Search);

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                recyclerView.setVisibility(View.VISIBLE);
                Serch.this.serchAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
    }
    private void getDSSerch (){
        list = serchDao.getDS();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Serch.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        serchAdapter = new SerchAdapter(this,list,serchDao);
        recyclerView.setAdapter(serchAdapter);

    }




}