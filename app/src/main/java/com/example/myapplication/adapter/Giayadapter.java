package com.example.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class Giayadapter extends RecyclerView.Adapter<Giayadapter.ViewHolder> {
    private Context context;
    private ArrayList<Product> list;

    public Giayadapter(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_giay, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tengiay.setText(list.get(position).getTengiay());
        holder.gia.setText(String.valueOf(list.get(position).getGia()));
        holder.soluong.setText(String.valueOf(list.get(position).getSoluong()));
        holder.mausac.setText(list.get(position).getMausac());
        holder.kichco.setText(String.valueOf(list.get(position).getKichco()));
        holder.maloaigiay.setText(String.valueOf(list.get(position).getMaloaigiay()));
        //        chuyen byte[] thanh bitmap
        byte [] hinh =  list.get(position).getAnh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinh,0,hinh.length);
        holder.anh.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tengiay,gia,soluong,mausac,kichco,maloaigiay;
        ImageView anh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tengiay = itemView.findViewById(R.id.tengiay);
            gia = itemView.findViewById(R.id.gia);
            soluong = itemView.findViewById(R.id.soluong);
            mausac = itemView.findViewById(R.id.mausac);
            kichco = itemView.findViewById(R.id.kichco);
            maloaigiay = itemView.findViewById(R.id.maloaigiay);
            anh = itemView.findViewById(R.id.anh);

        }
    }
}
