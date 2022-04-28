package com.example.ex220322;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment2 extends Fragment { // 부모 프래그먼트

    // 변수
    ViewPager2 viewPager2;

    public Fragment2(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_2, container, false);

        viewPager2 = view.findViewById(R.id.viewPager2);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity(), 2);
        viewPager2.setAdapter(adapter);

        return view;
    }
}