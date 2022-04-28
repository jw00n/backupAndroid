package com.example.ex220302;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView tv_login;
    EditText et_id, et_pw;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam06);

        tv_login=findViewById(R.id.tv_login);
        et_id=findViewById(R.id.et_id);
        et_pw=findViewById(R.id.et_pw);
        btn_login=findViewById(R.id.btn_login);

        //1. btn_login을 클릭하면

        //익명클래스로
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //2. et_id,et_pw의 값을 읽어와
                //3.  String id와 String pw에 저장한다.
                String id=et_id.getText().toString();
                String pw=et_pw.getText().toString();


                //0. 중간에 값을 확인하고싶을때?
                //log를 사용해 key,value로 값을 확인
                Log.v("로그인", id);
                Log.v("비밀번호", pw);

                //약자가 뭔지 알아둬용
                
                //Toast 메세지
                Toast.makeText(MainActivity2.this, id+"/"+pw, Toast.LENGTH_SHORT).show();
                // smhrd, 1234 라면
                if(id.equals("smhrd")&&pw.equals("1234")) {
                    tv_login.setText(id + "님 환영합니다.");
                        //tv_login 을 smhrd 님 환영합니다. 로 바꾸자.
                    Intent intent = new Intent(MainActivity2.this, ResultActivity.class);
                    intent.putExtra("id",id);
                    startActivity(intent);

                }else{
                  //  tv_login.setText("로그인 해주세요.");
                    Toast.makeText(MainActivity2.this, "다시 로그인하십쇼", Toast.LENGTH_SHORT).show();

                }



                //현재 액티비티를 종료하는 메소드
                finish();
            }
        });

    }
}