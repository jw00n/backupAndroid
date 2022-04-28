package com.example.ex220302;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    TextView tvResult1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resylt);

        tvResult1=findViewById(R.id.tvResult1);
        Intent intent = getIntent();
        //인텐트에 저장되어있는 데이터를 접근하기위해서 인텐트 객체 생성
        String id= intent.getStringExtra("id");
        tvResult1.setText(id+"님 환영합니다.");

    }
}