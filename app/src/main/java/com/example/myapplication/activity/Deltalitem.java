package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.GiayUserAdapter;
import com.example.myapplication.adapter.GioHangAdapter;
import com.example.myapplication.dao.GiayDAO;
import com.example.myapplication.model.ItemGioHang;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class Deltalitem extends AppCompatActivity {
      GiayDAO dao;

      ArrayList<Product> list;
       Button btndathang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motasanpham);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Product product = (Product) bundle.getSerializable("truyenne");
        TextView txtdelta = findViewById(R.id.txtten);
        txtdelta.setText(product.getTengiay());
        TextView txtgia = findViewById(R.id.txtgia);
        txtgia.setText(String.valueOf(product.getGia()));

        dao = new GiayDAO(Deltalitem.this);
         btndathang = findViewById(R.id.btndathang);
         btndathang.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 SharedPreferences sharedPreferences = getSharedPreferences("THONGTIN",MODE_PRIVATE);
                 String tk = sharedPreferences.getString("taikhoan",null);
                 if (dao.themVaoGH(product.getMagiay(),1,tk)){
                     Toast.makeText(Deltalitem.this, "thêm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show();
                 }else {
                     Toast.makeText(Deltalitem.this, "thất bại", Toast.LENGTH_SHORT).show();
                 }
             }
         });

    }

}


