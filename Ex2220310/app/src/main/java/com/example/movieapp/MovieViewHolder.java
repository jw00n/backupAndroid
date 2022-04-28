package com.example.movieapp;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ex2220310.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private ImageView imgPoster;

    public MovieViewHolder(@NonNull View itemView, OnItemClickListener listener) {
        super(itemView);

        imgPoster = itemView.findViewById(R.id.imgPoster);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //클릭했을 때 아이템뷰의 위치정보를 변수에 저장
                int position = getAdapterPosition();

                if(position != RecyclerView.NO_POSITION){
                    if(listener !=null){
                        listener.onItemClick(view, position);
                    }
                }
            }
        });


    }

    public ImageView getImgPoster() {
        return imgPoster;
    }
}
