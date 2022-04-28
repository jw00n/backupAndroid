package com.example.ex220302;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    //onclick 메소드 구현해야됨.


    //전역 변수 선언
    TextView tv_result;
    EditText et_num1,et_num2;
    Button btn_plus, btn_minus, btn_multi, btn_div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam05);


        //1. 출력문자를 hello world로 바꿔봅시다.
        tv_result=(TextView)findViewById(R.id.tv_result);
        tv_result.setText("Hello world");


        //문제 정의
        //1.et_num1 id에 접근해서 edittext를 가져와서

        //inner class
        //다운캐스팅 안해도 그대로 되네?
        //안 써도 자동캐스팅 되게 컴파일됨.
        et_num1= findViewById(R.id.et_num1);
        et_num2= findViewById(R.id.et_num2);

        //alt+enter 자동 import
        btn_plus=findViewById(R.id.btn_plus);
        btn_minus=findViewById(R.id.btn_minus);
        btn_multi=findViewById(R.id.btn_multi);
        btn_div=findViewById(R.id.btn_div);


        //버튼을 눌럿을때.

        // --- !! 거의 사용 안되는 방법 --
        btn_multi.setOnClickListener(this); //마우스 클릭 이벤트를 감지하는 리스너 셋팅
        //this는 클래스 내부의 onClick()을 가리킴.

        // 익명 클래스를 활용한 방법
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1= et_num1.getText().toString();
                String str2= et_num2.getText().toString();

                int num1=Integer.parseInt(str1);
                int num2=Integer.parseInt(str2);

                int result= num1/num2;
                tv_result.setText(result+"");
            }
        });
    }

    //plus를 눌렷을때
    public void plus(View view){
        //tv_result의 값을 더하기 버튼 클릭됨.
        tv_result.setText("더하기 버튼 클릭");

        int num1=Integer.parseInt(et_num1.getText().toString());
        int num2=Integer.parseInt(et_num2.getText().toString());

        int result=num1+num2;

        //그냥 넣으면 오류가 나요

        //String.valueOf()
        tv_result.setText(""+result);

    }

    public void minus(View view){
        //tv_result의 값을 더하기 버튼 클릭됨.
        tv_result.setText("빼기 버튼 클릭");

        int num1=Integer.parseInt(et_num1.getText().toString());
        int num2=Integer.parseInt(et_num2.getText().toString());

        int result=num1-num2;

        //그냥 넣으면 오류가 나요

        //String.valueOf()
        tv_result.setText(""+result);

    }


    @Override
    public void onClick(View view) {

        //곱하기 기능
        // 1. et_num1  과 et_num2의 값을 가져온다.
        int num1=Integer.parseInt(et_num1.getText().toString());
        int num2=Integer.parseInt(et_num2.getText().toString());

        //2. 정수형으로 변환시켜서
        //3. 두 값을 곱해준 후에 result에 담아준다.

        int result=num1*num2;

        //4. tv_result에 결과값을 출력
        tv_result.setText(""+result);
    }
}