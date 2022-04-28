package com.example.ex220322;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    int count; //View pager2에 보여질 fragment의 개수


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity,int count) {
        super(fragmentActivity);
        this.count=count;

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = position%count;

        if(index== 0){
            return new FragmentChild1();
        }else{
            return new FragmentChild2();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
