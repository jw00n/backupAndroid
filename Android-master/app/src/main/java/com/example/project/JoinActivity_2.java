package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JoinActivity_2 extends AppCompatActivity {
    Button btnCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.join_2);

       btnCon = findViewById(R.id.btnCon);

       btnCon.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(JoinActivity_2.this,JoinActivity_3.class);
               startActivity(intent);
           }
       });

    }
}