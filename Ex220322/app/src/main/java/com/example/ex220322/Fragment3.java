package com.example.ex220322;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment3 extends Fragment {

    EditText edtUrl;
    Button btnSave;


    public Fragment3() {
        // Required empty public constructor
    }

    //작은 양의 데이터를 저장할때 사용하는 객체...
    //객체를 통해 데이터를 저장 --> 파일형태로 안드로이드에 저장



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_3, container,false);

        edtUrl=view.findViewById(R.id.edtUrl);
        btnSave=view.findViewById(R.id.btnSave);

        SharedPreferences spf = getActivity().getSharedPreferences("mySDF", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit(); //편집


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url= edtUrl.getText().toString();

                //https://를 안 붙였을 경우를 위해
                if(!url.startsWith("https://")){
                    url = "https://"+url;
                }

                Log.d("url :", url);
                editor.putString("url",url);
                editor.commit();


                Toast.makeText(getActivity(), "주소가 "+url+"로 변경되었습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        }); //end

        return view;
    }
}