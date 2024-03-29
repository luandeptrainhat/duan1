package com.example.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.dao.GiayDAO;
import com.example.myapplication.model.ItemGioHang;

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
        holder.txtSoluong.setText(String.valueOf("Số lượng: " + list.get(position).getSoLuong()));
        //        chuyen byte[] thanh bitmap
        byte[] hinh = list.get(position).getAnh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinh, 0, hinh.length);
        holder.anh.setImageBitmap(bitmap);
        holder.btnXoaGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (giayDAO.xoaItemGH(list.get(holder.getAdapterPosition()).getMagiohang())) {
                    getDS();
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (holder.chkItemGH.isSelected()) {
            if (giayDAO.doiTrangThaiGH1(list.get(holder.getAdapterPosition()).getMagiohang())) {
                Toast.makeText(context, "thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "thất bại", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (giayDAO.doiTrangThaiGH0(list.get(holder.getAdapterPosition()).getMagiohang())) {
                Toast.makeText(context, "thành công", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(context, "thất bại", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tengiay, gia, txtSize, txtSoluong;
        Button btnXoaGioHang;
        CheckBox chkItemGH;
        ImageView anh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tengiay = itemView.findViewById(R.id.tengiay);
            gia = itemView.findViewById(R.id.gia);
            anh = itemView.findViewById(R.id.anh);
            txtSize = itemView.findViewById(R.id.txtSize);
            txtSoluong = itemView.findViewById(R.id.txtSoluong);
            btnXoaGioHang = itemView.findViewById(R.id.btnXoaGioHang);
            chkItemGH = itemView.findViewById(R.id.chkItemGH);
        }
    }

    private void getDS() {
        list.clear();
        SharedPreferences sharedPreferences = context.getSharedPreferences("THONGTIN", context.MODE_PRIVATE);
        String tk = sharedPreferences.getString("taikhoan", null);
        list = giayDAO.layItemGioHang(tk);
        notifyDataSetChanged();
    }
}
