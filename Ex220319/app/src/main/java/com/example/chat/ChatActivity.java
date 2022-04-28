package com.example.chat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ex220319.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ChatActivity extends AppCompatActivity {
    RecyclerView rcChatlist;
    EditText edtMsg;
    Button btnMsgSend;

    String currentId;

    ChatAdapter adapter;

    String fburl = "https://mjproject-cefdd-default-rtdb.firebaseio.com/";
    FirebaseDatabase database = FirebaseDatabase.getInstance(fburl);
    DatabaseReference myRef = database.getReference("talk");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        rcChatlist=findViewById(R.id.rcChatlist);
        edtMsg=findViewById(R.id.edtMsg);
        btnMsgSend=findViewById(R.id.btnMsgSend);

        currentId=getIntent().getStringExtra("id");


        adapter=new ChatAdapter();
        adapter.setCurrentId(currentId);
        //리사이클 뷰는 미리 정의 해야한다.
        rcChatlist.setLayoutManager(new LinearLayoutManager(this)); //this로 하면, 기본값으로 default가 들어감.ㅡ
        rcChatlist.setAdapter(adapter);



        btnMsgSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg= edtMsg.getText().toString();

                //현재 시간값이 필요.
                Calendar cal =Calendar.getInstance();
                SimpleDateFormat sdf= new SimpleDateFormat("hh시 mm분");
                //안드로이드꺼 말고 자바거ㅡ


                Log.d("chatAct", cal.getTime().toString());
                Log.d("chatAct",sdf.format(cal.getTime()));


                ChatVO vo = new ChatVO(R.drawable.person,currentId,
                        msg, sdf.format(cal.getTime()) );
                Log.d("오류11",vo.getName());

                //실시간 데이터베이스에 랜덤한 키로 채팅데이터를 저장
                myRef.push().setValue(vo);
                edtMsg.setText(""); //입력하고 난 뒤에는 지워지도록


            }
        });


        //실시간 데이터베이스에 저장된 데이터를 모두 읽어와
        //리사이클 뷰에 출력
        //배고프다ㅏㅏㅏ

        //아래에 데이터가 생겼을때 반응해줄 리스너
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ChatVO vo = dataSnapshot.getValue(ChatVO.class); //? json에 이 정보도 같이 저장이 되나?
                adapter.addItem(vo);
                adapter.notifyDataSetChanged(); //리사이클러뷰를 갱신해주는 역할
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}