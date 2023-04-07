package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.activity.MainKhach;
import com.example.myapplication.activity.TestHienGiay;
import com.example.myapplication.adapter.Giayadapter;
import com.example.myapplication.dao.GiayDAO;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class fragmentDSGiay extends Fragment {
    GiayDAO giayDAO;
    Giayadapter giayadapter;
    ArrayList<Product> list;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danhsachsanpham,container,false);
        recyclerView = view.findViewById(R.id.recycleview);
        getDS();
        return view;
    }
    private void getDS(){
        giayDAO = new GiayDAO(getContext());
        list = giayDAO.getDSPRO();
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(linearLayoutManager);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        giayadapter = new Giayadapter(getContext(),list,giayDAO);
        recyclerView.setAdapter(giayadapter);
    }

}
