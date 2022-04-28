package com.example.ex220325;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTime,tv2;
    Button btnStart,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime=findViewById(R.id.tvTime);
        btnStart=findViewById(R.id.btnStart);

        tv2=findViewById(R.id.tv2);
        btn2=findViewById(R.id.btn2);

        //버튼을 클릭했을때 스레드가 동작되도록 구현해보기
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestThread thread=new TestThread(tvTime);
                thread.start();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestThread thread2=new TestThread(tv2);
                thread2.start();
                btn2.setEnabled(false);// 비활성화
            }
        });

    }

    //Thread
    class TestThread extends Thread{

        TextView tv;
        public TestThread(TextView tv){
            this.tv=tv;

        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Log.d("mainAct", "스레드 실행");
                //TextView를 카운트되도록정의

                Message msg=new Message();
                msg.arg1=i+1;
                msg.obj=tv;

                handler.sendMessage(msg);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            }


        }
    }

    //핸들러 : 스레드에서 처리한 결과를 메인스레드로 전달해주는 역할
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            TextView tv=(TextView) msg.obj;
            tv.setText(String.valueOf(msg.arg1));
        }
    };


    class TestThread2 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Message msg = new Message();
                msg.arg1 = i+1;
                handler2.sendMessage(msg);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    Handler handler2=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {

            tv2.setText(String.valueOf(msg.arg1));
        }
    };
}