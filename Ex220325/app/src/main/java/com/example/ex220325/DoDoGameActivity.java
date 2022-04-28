package com.example.ex220325;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class DoDoGameActivity extends AppCompatActivity {

    TextView tvCount,tvDoTime;
    ImageView[] imgArray=new ImageView[9];
    int result;
    boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_do_game);


        tvCount=findViewById(R.id.tvCount);
        tvDoTime=findViewById(R.id.tvDoTime);

        //====게임 시작
        isPlaying = true;
        DoTimeThread doTimeThread= new DoTimeThread(Integer.parseInt((String) tvDoTime.getText()));
        doTimeThread.start();
        for(int i=0; i<imgArray.length; i++){
            //인덱스용 변수 상수 선언
            final  int index= i; //반복문마다 새로 할당하게 될 것.

           int imgId= getResources().getIdentifier(
                   "img"+(i+1),"id",getPackageName());

            imgArray[i]=findViewById(imgId);

            //이미지 Tag 값 저장->> 두더지를 클릭했을때ㅔ on상태인지 off상태인지 판단
            imgArray[i].setTag("off");

            //이미지를 클릭했을 때 잡은 갯루를 카운트 하는 기능
            imgArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { //추어ㅝ어어어어

                    //상수값으로 인덱싱해주세요 << 오류원인
                    //이유 : 익명클래스에서 변수를 사용할때 값이 변하면 외부 클래스에 영향을 줄 수 있기 때문.
                    String status=imgArray[index].getTag().toString();

                    //클릭시 textview 에 점수 올리기 ( 0이하는 없게!
                    if(status.equals("on")){ //on
                        Log.d("두더지", "두더지 잡기 성공");
                        result++;

                        tvCount.setText(String.valueOf(result));

                    }else{ //off
                        Log.d("두더지", "두더지 잡기 실패");
                        if(result>0){
                            result--;
                            tvCount.setText(String.valueOf(result));
                        }else{ //0점일때

                        }

                    }
                }
            });
            Dothread dothread = new Dothread(i);
            dothread.start();
        } //for문 종료

    }

    class DoTimeThread extends Thread{
        int time;
        public DoTimeThread(int time){
            this.time=time;
        }

        @Override
        public void run() {

            while(time>0){
                Message msg= new Message();
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                time--;
                msg.arg1=time;
                doTimeHandler.sendMessage(msg);
            }

        }
    }

    Handler doTimeHandler= new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
          tvDoTime.setText(String.valueOf( msg.arg1));
          //시간이 0이 됐을때 움직임을 멈추는 정의
            if(msg.arg1 == 0){
                isPlaying = false;
            }
        }
    };

    class  Dothread extends Thread{

        int position;
        public Dothread(int position){
            this.position=position;
        }
        @Override
        public void run() {

          //타임오버 기능으로 종료할거임
            while(isPlaying){
                //랜덤값으로 sleep 메소드 생성
                Random rd=new Random();
                int downTime= rd.nextInt(3000);
                int upTime=rd.nextInt(1000);


                try {
                    Thread.sleep(downTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg= new Message();
                msg.arg1=position;
                msg.arg2=R.drawable.on; //올라가는 상태의 이미지
                msg.obj="on";
                doHandler.sendMessage(msg);


                try {
                    Thread.sleep(upTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //두더지 off에 대한 값을 저장
                msg=new Message();
                msg.arg1=position;
                msg.arg2=R.drawable.off;
                msg.obj="off";
                doHandler.sendMessage(msg);


            }


        }
    }

    Handler doHandler= new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            int pos=msg.arg1;
            int imgId=msg.arg2;
            String status = (String) msg.obj;

            imgArray[pos].setImageResource(imgId);
            imgArray[pos].setTag(status);
        }
    };
}