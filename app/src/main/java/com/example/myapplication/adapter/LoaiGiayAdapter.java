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
import com.example.myapplication.model.LoaiGiay;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class LoaiGiayAdapter extends RecyclerView.Adapter<LoaiGiayAdapter.ViewHolder> {
    private Context context;
    private ArrayList<LoaiGiay> list;

    public LoaiGiayAdapter(Context context, ArrayList<LoaiGiay> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_loaigiay, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTenloai.setText(list.get(position).getTenloai());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTenloai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenloai = itemView.findViewById(R.id.tenloai);
        }
    }
}
