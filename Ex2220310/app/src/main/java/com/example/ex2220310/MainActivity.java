package com.example.ex2220310;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView ListView;
    ArrayList<String> dataset;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView = findViewById(R.id.listview);
        dataset = new ArrayList<>();

        //임의의 데이터저장
        for(int i=1; i<=20; i++){
            dataset.add(String.valueOf(i));
        }

        //context= 액티비티의 정보
        // 아이템뷰 레이아웃: 어댑터뷰에 (리스트뷰, 그리드뷰, ....) 출력할 아이템뷰의 형태
        //데이터 : 아이템뷰에 보여줄 데이터
        adapter = new ArrayAdapter<String>(MainActivity.this,
                                            android.R.layout.simple_list_item_1,
                                            dataset);
        ListView.setAdapter(adapter);

    }
}