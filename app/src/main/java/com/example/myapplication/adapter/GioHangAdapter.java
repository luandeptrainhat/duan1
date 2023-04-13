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
import com.example.myapplication.dao.GiayDAO;
import com.example.myapplication.model.ItemGioHang;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ItemGioHang> list;
    private GiayDAO giayDAO;

    public GioHangAdapter(Context context, ArrayList<ItemGioHang> list, GiayDAO giayDAO) {
        this.context = context;
        this.list = list;
        this.giayDAO = giayDAO;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_giohang, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tengiay.setText(list.get(position).getTen());
        holder.gia.setText(String.valueOf(list.get(position).getGia()));
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
        TextView tengiay,gia;
        ImageView anh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tengiay = itemView.findViewById(R.id.tengiay);
            gia = itemView.findViewById(R.id.gia);
            anh = itemView.findViewById(R.id.anh);
        }
    }
}
