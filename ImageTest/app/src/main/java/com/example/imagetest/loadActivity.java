package com.example.imagetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.bumptech.glide.Glide;

public class loadActivity extends AppCompatActivity {


    ImageView imgTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        imgTest=findViewById(R.id.imgTest);



        String url="https://s3.us-east-2.amazonaws.com/momoyami/moim/test22.jpg";
        Glide.with(this).load(url).error(R.drawable.dog).into(imgTest);



    }
}