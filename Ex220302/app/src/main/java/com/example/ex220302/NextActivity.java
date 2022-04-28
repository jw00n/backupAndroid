
package com.example.ex220302;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    Button btnNext;
    TextView tvData2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);


        btnNext=findViewById(R.id.btnNext);
        tvData2=findViewById(R.id.tvData2);

        Intent intent = getIntent();
        //인텐트에 저장되어있는 데이터를 접근하기위해서 인텐트 객체 생성
        String text= intent.getStringExtra("text");
        //데이터에 접근
        int number=intent.getIntExtra("number",0);

        tvData2.setText(text+String.valueOf(number));

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, MainActivity7.class);

                startActivity(intent);
            }
        });
    }
}