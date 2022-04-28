package com.example.ex220319;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //url 오류 해결 ->
        String fburl="https://ex220319-jw00n-default-rtdb.firebaseio.com/";

        // Write a message to the database
        //객체 생성
        FirebaseDatabase database = FirebaseDatabase.getInstance(fburl);
        //참조할 경로를 객체로 생성 -> 없으면 자동생성된다.
        DatabaseReference myRef = database.getReference("Lunch");

        //실시간 데이터 베이스에 저장
        //{"":""}와 같이 JSON 구조로 저장한다.
      //  myRef.setValue("산뜻한 음식");

        DataVO vo= new DataVO("1","2","3");
        myRef.push().setValue(vo);
        //push() :랜덤한 값으로 새로운 경로를 생성해줍니다
        //setValue 의 매개변수는 Object라서 그냥 다 집어넣을수있다
        //변수명이 key값이 된당



        // Read from the database

        //접근할 경로 아래에 있는 key-value 구조 접근할 시,
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DataVO data= dataSnapshot.getValue(DataVO.class); //데이터 타입
                //인수가 없는 생성자가 필요할수도 있따.
                Log.d("tag", data.getData1()+"/"+data.getData2()+"/"+data.getData3());

              //  String data= dataSnapshot.getValue(String.class);
               // Log.d("tag", "Value is "+data);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
              //  String data= dataSnapshot.getValue(String.class);
               // Log.d("tag", "changed Value is "+data);
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

        //부모자식구조가 된 경우에는 아래 이벤트리스너를 사용할수업다.
        //접근할 경로의 데이터를 접근할때
        /*
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("tag", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("tag", "Failed to read value.", error.toException());
            }
        });

         */


    }
}