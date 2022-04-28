package com.example.ex220302;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity6 extends AppCompatActivity {

    Button btnWebView, btnCamera, btnDial, btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        btnWebView = findViewById(R.id.btnWebView);
        btnCamera = findViewById(R.id.btnCamera);
        btnDial=findViewById(R.id.btnDial);
        btnCall=findViewById(R.id.btnCall);

        //각 버튼에 클릭 이벤트 적용

        btnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.naver.com/"));
                //인텐트 객체생성
                startActivity(intent);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View view) {
                Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
            });

            btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:01012345678"));
                startActivity(intent);
            }

        });

            btnCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:01012345678"));

                   //사용자에게 권한허용에 대한 요청/확인인
                    //실행 -> 사용자 권환을 확인함 -> 없으면 권한 요청
                    if(ContextCompat.checkSelfPermission(MainActivity6.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                        ActivityCompat.requestPermissions(MainActivity6.this,
                                new String[]{Manifest.permission.CALL_PHONE},0);
                        return;
                    }


                    startActivity(intent);
                }
            });
    }
}