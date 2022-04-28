package com.example.ex220322;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentChild1 extends Fragment {

    EditText edtData;
    Button btnSend;

    public FragmentChild1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_child1, container, false);

        edtData = view.findViewById(R.id.edtId);
        btnSend= view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= edtData.getText().toString();

                //프래그먼트간 데이터 전달
                //1. bundle객체에 데이터를 저장
                //2. fragmentManagaer객체에 bundle를 저장

                Bundle bundle = new Bundle();
                bundle.putString("data", data);

                getParentFragmentManager().setFragmentResult("fData",bundle);

            }
        });

        return view;
    }
}