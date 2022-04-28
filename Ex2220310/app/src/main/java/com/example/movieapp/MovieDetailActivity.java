package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ex2220310.R;

public class MovieDetailActivity extends AppCompatActivity {

    ImageView imgDetailPoster;
    TextView tvDetailRank, tvDetailMovieNm,tvDetailOpenDt, tvDetailAudiAcc, tvDetailDesc;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        //뷰 객체 초기화
        initView();

        Intent intent = getIntent();

        imgDetailPoster.setImageResource(intent.getIntExtra("imgPoster",R.drawable.movie1));
        tvDetailRank.setText(intent.getStringExtra("rank"));
        tvDetailMovieNm.setText(intent.getStringExtra("movieNm"));
        tvDetailOpenDt.setText(intent.getStringExtra("openDt"));
        tvDetailAudiAcc.setText(intent.getStringExtra("audiAcc"));
        tvDetailDesc.setText(intent.getStringExtra("description"));


    }

    private void initView() {
        imgDetailPoster=findViewById(R.id.imgDetailPoster);
        tvDetailRank=findViewById(R.id.tvDetailRank);
        tvDetailMovieNm=findViewById(R.id.tvDetailMovieNm);
        tvDetailOpenDt=findViewById(R.id.tvOpenDt);
        tvDetailAudiAcc=findViewById(R.id.tvDetailAudiAcc);
        tvDetailDesc=findViewById(R.id.tvDetailDesc);
    }
}