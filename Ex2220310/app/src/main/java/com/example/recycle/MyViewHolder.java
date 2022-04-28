package com.example.recycle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.ex2220310.R;

//
public class MyViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView textView;

    //자동완성 alt enter
    //itemView 객체 -> list_item.xml
    public MyViewHolder(View itemView, OnItemClickListener clickListener) {
        super(itemView);

        //find가 안되서 itemView에서 빼옴
        this.imageView = itemView.findViewById(R.id.imageView);
        this.textView = itemView.findViewById(R.id.textView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //클릭했을 때 아이템뷰의 위치정보를 변수에 저장
                int position = getAdapterPosition();

                if(position != RecyclerView.NO_POSITION){
                    if(clickListener !=null){
                        clickListener.onItemClick(view, position);
                    }
                }
            }
        });

    }
    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }
}


