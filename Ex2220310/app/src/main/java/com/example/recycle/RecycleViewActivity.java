package com.example.recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ex2220310.R;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity {

    ArrayList<String> list;
    RecyclerView rc;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        rc=findViewById(R.id.movieList2);
        list= new ArrayList<>();


        for(int i=0; i<20; i++){
            list.add("홍0동"+(i+1));
        }

        adapter = new MyAdapter(list);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String name= list.get(position);
                Toast.makeText(RecycleViewActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });
            //LinearlayoutManager : 수직/수평 레이아웃
        //리버스 레이아웃: 출력되는 방향을설정.

     /*
        rc.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,true));
       */



        rc.setLayoutManager(new GridLayoutManager(this, 2));
        rc.setAdapter(adapter);

    }
}