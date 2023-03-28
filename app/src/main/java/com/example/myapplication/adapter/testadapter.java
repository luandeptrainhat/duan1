package com.example.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class testadapter extends RecyclerView.Adapter<testadapter.ViewHolder> {
    private Context context;
    private ArrayList<Product> list;

    public testadapter(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.testlist_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtname.setText(list.get(position).getTengiay());
        holder.txtgia.setText(String.valueOf(list.get(position).getGia()));
        holder.txtsoluong.setText(String.valueOf(list.get(position).getSoluong()));
        holder.txtmausac.setText(list.get(position).getMausac());
        holder.txtsize.setText(String.valueOf(list.get(position).getKichco()));
      //  holder.txthinhanh.setText(list.get(position).getAnh());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtname, txtgia, txtsoluong, txtmausac, txtsize, txthinhanh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname= itemView.findViewById(R.id.tenpro);
            txtgia= itemView.findViewById(R.id.giapro);
            txtsoluong= itemView.findViewById(R.id.soluongpro);
            txtmausac= itemView.findViewById(R.id.mausacpro);
            txtsize= itemView.findViewById(R.id.sizepro);
            txthinhanh= itemView.findViewById(R.id.imgpro);
        }
    }
}
