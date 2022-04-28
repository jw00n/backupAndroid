package com.example.ex220302;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity4 extends AppCompatActivity {

    TextView tv_score;
    ImageView[] imgs;
    Button btn_shake;

    int[] dices;

    int first,second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        first=0;
        second=0;


        dices = new int[]{R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,
                R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

        tv_score=findViewById(R.id.tv_score);
        btn_shake=findViewById(R.id.btn_shake);

        imgs= new ImageView[2];


        for(int i=0; i<imgs.length; i++){
            int resID=getResources().getIdentifier("img"+(i+1),"id",getPackageName());
            imgs[i]= findViewById(resID);
        }


        //셰이크 버튼을 눌렀을 때
        // 두개의 난수를 뽑고 1난수는 첫번째 주사위
        //큰 수가 나온 쪽을 1:0
        //무승부는 변화없이 toast로 무승부입니다.를 표시할것

        btn_shake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rd=new Random();
                int num1= rd.nextInt(6);
                int num2=rd.nextInt(6);

                //값 확인용 로그 출력
                Log.e("랜덤값",num1+"");
                Log.e("랜덤값",num2+"");


               imgs[0].setImageResource(dices[num1]);
               imgs[1].setImageResource(dices[num2]);

                if(num1>num2){
                    first++;
                }else if(num1<num2){
                    second++;
                }else{ //무승부
                    Toast.makeText(MainActivity4.this, "무승부입니다.", Toast.LENGTH_SHORT).show();
                }

                tv_score.setText(first+" : "+second);

            }
        });
    }
}