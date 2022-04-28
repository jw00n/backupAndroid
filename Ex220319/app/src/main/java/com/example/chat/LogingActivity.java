package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ex220319.R;

public class LogingActivity extends AppCompatActivity {

    EditText edtUserId, edtUserPw;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loging);

        edtUserId=findViewById(R.id.edtUserId);
        edtUserPw=findViewById(R.id.edtUserPw);
        btnLogin=findViewById(R.id.btnLogin);

        //버튼을 클릭했을때 id,pw를 비교하여 일치시 chatActivity 로 이동하는 기능구현
        //아이디,비번은 임의로 설정


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=edtUserId.getText().toString();
                String pw =edtUserPw.getText().toString();

               if(id.equals("momo")&& pw.equals("1234")){
                   Intent intent = new Intent(LogingActivity.this, ChatActivity.class);

                   //채팅화면에서 상대방에게  id를 보여주는 용도
                   intent.putExtra("id",id);
                   startActivity(intent);

               }else{
                   Toast.makeText(LogingActivity.this, "잘못된 입력입니다.", Toast.LENGTH_SHORT).show();
               }

            }
        });
    }
}