package com.example.ex220302;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

public class MainActivity5 extends AppCompatActivity {

    public  static  final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // 자주 쓰이는 TAG라면 변수를 만들어서 실행한다
        Log.d(TAG, "onCreate() 실행!");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() 실행!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() 실행!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() 실행!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() 실행!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() 실행!");
    }

    // 완전 종료
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() 실행!");
    }
}