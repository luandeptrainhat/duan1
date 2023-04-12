package com.example.myapplication.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragment.FragmentXuLiDonHang;

public class ViewPager2Adapter extends FragmentStateAdapter {
     public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 :
                return new FragmentXuLiDonHang();

            default:
                return new FragmentXuLiDonHang();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
