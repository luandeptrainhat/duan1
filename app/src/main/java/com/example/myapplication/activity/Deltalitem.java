package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.Product;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class Deltalitem extends AppCompatActivity {
    private List<Product> list;
    private  int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motasanpham);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Product product = (Product) bundle.get("truyenne");

        TextView txtdelta = findViewById(R.id.txtten);
        txtdelta.setText(product.getTengiay());
        TextView txtgia = findViewById(R.id.txtgia);
        txtgia.setText(String.valueOf(product.getGia()));
//        ImageView imganhne = findViewById(R.id.imganhne);
//
//        byte [] hinh =  list.get(pos).getAnh();
//        Bitmap bitmap = BitmapFactory.decodeByteArray(hinh,0,hinh.length);
//        imganhne.setImageBitmap(bitmap);

    }

}
