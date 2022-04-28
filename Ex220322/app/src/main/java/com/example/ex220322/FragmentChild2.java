package com.example.ex220322;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentChild2 extends Fragment {

    TextView tvData;

    public FragmentChild2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_child2, container, false);

        tvData= view.findViewById(R.id.tvData);

        getParentFragmentManager().setFragmentResultListener(
                "fData",
                this,
                new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        String data= result.getString("data");
                        tvData.setText("Child1에서 전달받은 변수"+data);


                    }
                }
        );




        return view;
        }
}