package com.example.ex220302;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity3 extends AppCompatActivity {

    ImageView img;
    Button btn_pre, btn_next,   btn_test;
    int[] imgs; //이미지 resid를 담을 배열
    // imageResource는 int형 매개변수를 받는다.
    int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        img= findViewById(R.id.img);
        btn_next=findViewById(R.id.btn_next);
        btn_pre=findViewById(R.id.btn_pre);
        btn_test=findViewById(R.id.btn_test);

        imgs= new int[]{
                R.drawable.icon1,
                R.drawable.icon2,
                R.drawable.icon3,
                R.drawable.icon4,
                R.drawable.icon5};

        //btn_test를 누르면 이미지가 사라지게 --

        //java특징 : 함수식 표현이 가능하다.
        // lambda expression -> 자바 1.8버전 이상

    num=0;

        //이미지 보이기 / 안 보이기
        btn_test.setOnClickListener(v -> { //v는 매개변수 //두 개 이상은 (v, s ) ->{} 로 써야됨.
            //btn_test를 눌렀을 때, 실행되는 로직
            //1. 직관적

            //visible과 invisible 반복하게끔.

            // int값이네  boolean 값은 아닌듯
            if(img.getVisibility() == View.INVISIBLE) {
                img.setVisibility(View.VISIBLE);
            }else{
                img.setVisibility(View.INVISIBLE); //괄호 안의 값을  ctrl+space로 예시 볼수잇음
            }

            Boolean check = true;
            check=!check;

        });

        //다음 이미지 보여주기


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //img.setImageResource(R.drawable.icon3);
                //찾아가는 경로를 체크해주세요.

                if(num==imgs.length-1){
                    num=0;
                }else {
                    num++;
                }
                img.setImageResource(imgs[num]);

            }
        });

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num==0){
                    num=imgs.length-1;
                }else{
                num--;
                }

                img.setImageResource(imgs[num]);

            }
        });
    }
}