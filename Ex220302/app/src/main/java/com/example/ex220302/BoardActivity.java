package com.example.ex220302;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BoardActivity extends AppCompatActivity {

    TextView tvUserid;
    Button btnLoginMove;

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //로그인 액티비티에서 로그인 시도 했을 때 , 성공시 아이디 값을 반환해줌.
                    //intent에 저장된 아이디를 result매개변수로 꺼내와서 textview에 출력
                    if (result.getResultCode() == RESULT_OK){
                        String id=result.getData().getStringExtra("userId");
                        tvUserid.setText(id+"님은 로그인 중");

                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        tvUserid=findViewById(R.id.tvUserid);
        btnLoginMove=findViewById(R.id.btnLoginMove);

        btnLoginMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BoardActivity.this, LoginActivity.class);

                launcher.launch(intent);
            }
        });
    }
}