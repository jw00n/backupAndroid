package com.example.ex220302;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {

    Button btnMain,btnMain4;
    EditText editText;
    ConstraintLayout layout;

    ActivityResultLauncher<Intent> main7Launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //이동했던 화면으로부터 되돌아올때 실행하는 메소드
                    //이전화면에서 발생한 결과값을 매개변수에서 불러올수있음

                    //result.getResultCode() : 응답 결과코드 ( 값으로 Result ok / result cancel)
                    //result.getData() : 데이터 꺼내오기

                    if(result.getResultCode() == RESULT_OK){
                        String data=result.getData().getStringExtra("msg");
                        Toast.makeText(MainActivity7.this, data, Toast.LENGTH_SHORT).show();
                        String bgColor =result.getData().getStringExtra("bgColor");
                        layout.setBackgroundColor(Color.parseColor(bgColor));


                    }else{

                        Toast.makeText(MainActivity7.this, "데이터가 없습니다.", Toast.LENGTH_SHORT).show();

                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        btnMain=findViewById(R.id.btnMain);
        editText=findViewById(R.id.editText);

        btnMain4=findViewById(R.id.btnMain4);


        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity7.this, NextActivity.class);

                String text=editText.getText().toString();

                //intent에 데이터 저장
                //tag 이름 : 문자열로 지정
                //데이터 : 기본데이터 타입, 배열,arraylist 등 다양한 타입에 데이터 저장
                intent.putExtra("text",text);
                intent.putExtra("number",310);

                startActivity(intent);

                //현재 액티비티를 종료하는 메소드
                finish();

            }
        });

        btnMain4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity7.this, MainActivity8.class);

                //런치 메소드를 통해서 실행된 액티비티는 종료되었을때
                //regis~ 메소드가 실행되는 구조
                main7Launcher.launch(intent);
            }
        });
    }
}