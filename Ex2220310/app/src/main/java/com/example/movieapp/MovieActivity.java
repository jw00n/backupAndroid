package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import com.example.ex2220310.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MovieActivity extends AppCompatActivity {

    RecyclerView movieList;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);


        movieList=findViewById(R.id.movieList);
        adapter=new MovieAdapter();

        String jsonStr=readJson("movieList.json");

        //String -> Json Object 변환
        try {
            //{"movielist" : [...]}
            //String -> Json Object 변환
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray jsonArr =jsonObj.getJSONArray("movieList");
            //[{..},{..},{..}]

            for(int i=0; i<jsonArr.length(); i++){

                JSONObject movieJson = (JSONObject) jsonArr.get(i);

                //이미지 id값에 접근하는 방ㅂ법
                //10개의 버튼 뷰를 초기화해야할때
                //getIdentifier("btn"+(i+1), "id", getPackageName());
                int posterId= getResources().getIdentifier("movie"+(i+1),"drawable",getPackageName());
                String rank = movieJson.getString("rank");
                String movieNm = movieJson.getString("movieNm");
                String openDt = movieJson.getString("openDt");
                String audiAcc = movieJson.getString("audiAcc");
                String description = movieJson.getString("description");

                MovieVO movie=new MovieVO(posterId,rank,movieNm,openDt,audiAcc,description);


                adapter.addItem(movie);
                Log.d("영화정보>> ",movie.toString());


            }

           adapter.setListener(new OnItemClickListener() {
               @Override
               public void onItemClick(View view, int position) {
                   MovieVO vo =adapter.getItem(position);
                //   Log.d("선택한 영화명", vo.getMovieNm());
                   //클릭했을때 영화정보를 전달하자.
                   Intent intent = new Intent(MovieActivity.this, MovieDetailActivity.class);
                   intent.putExtra("imgPoster",vo.getPoster());

                   intent.putExtra("rank",vo.getRank());
                   intent.putExtra("movieNm",vo.getMovieNm());
                   intent.putExtra("openDt",vo.getOpenDt());
                   intent.putExtra("audiAcc",vo.getAudiAcc());
                   intent.putExtra("description",vo.getDescription());

                   startActivity(intent);
               }
           });
            movieList.setLayoutManager(new GridLayoutManager(this, 2));
            movieList.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private String readJson(String fileName) {
        AssetManager am = getResources().getAssets();
        StringBuffer sb=null;
        try {
            //json 파일을 문자열로 읽어오기 위한 방법
            InputStream is =am.open(fileName);
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader buffer= new BufferedReader(isr);

            //json 파일의 내용을 저장하는 변수
            sb = new StringBuffer();
            //계속 불러와야함.
            String line=buffer.readLine();

            //반복반복
            while(line!=null){
                sb.append(line+"\n"); //
                line= buffer.readLine();
            }

            Log.d("JSON데이터",sb.toString());
        }catch (IOException e){
            e.printStackTrace();
        }

        return sb.toString();
    }
}