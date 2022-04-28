package com.example.ex220302;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText edtId,edtPw;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtId=findViewById(R.id.edtId);
        edtPw=findViewById(R.id.edtPw);

        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id =edtId.getText().toString();
                String pw =edtPw.getText().toString();

                if(id.equals("smhrd")&&pw.equals("1234")){
                    Intent intent =new Intent();
                    intent.putExtra("userId",id);

                    //BoardActivity 에 있는 onActivityResult(result) 메소드에
                    //result ok -> result.getResultCode()
                    //intent -> result.getData()
                    setResult(RESULT_OK,intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "다시 입력해주세요.",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}