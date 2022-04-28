package com.example.chat;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ex220319.R;

public class ChayViewHolder extends RecyclerView.ViewHolder {

    private ImageView imgOther;
    private TextView tvOtherNm;
    private TextView tvOtherMsg;
    private TextView tvOtherTime;
    private TextView tvMyMsg;
    private TextView tvMyTime;


    public ChayViewHolder(@NonNull View itemView){
        super(itemView);
        imgOther=itemView.findViewById(R.id.imgOther);
        tvOtherNm=itemView.findViewById(R.id.tvOtherNm);
        tvOtherMsg=itemView.findViewById(R.id.tvOtherMsg);
        tvOtherTime=itemView.findViewById(R.id.tvOhterTime);

        tvMyMsg=itemView.findViewById(R.id.tvMyMsg);
        tvMyTime=itemView.findViewById(R.id.tvMytime);

    }


    public ImageView getImgOther() {
        return imgOther;
    }

    public void setImgOther(ImageView imgOther) {
        this.imgOther = imgOther;
    }

    public TextView getTvOtherNm() {
        return tvOtherNm;
    }

    public void setTvOtherNm(TextView tvOtherNm) {
        this.tvOtherNm = tvOtherNm;
    }

    public TextView getTvOtherMsg() {
        return tvOtherMsg;
    }

    public void setTvOtherMsg(TextView tvOtherMsg) {
        this.tvOtherMsg = tvOtherMsg;
    }

    public TextView getTvOtherTime() {
        return tvOtherTime;
    }

    public void setTvOtherTime(TextView tvOtherTime) {
        this.tvOtherTime = tvOtherTime;
    }

    public TextView getTvMyMsg() {
        return tvMyMsg;
    }

    public void setTvMyMsg(TextView tvMyMsg) {
        this.tvMyMsg = tvMyMsg;
    }

    public TextView getTvMyTime() {
        return tvMyTime;
    }

    public void setTvMyTime(TextView tvMyTime) {
        this.tvMyTime = tvMyTime;
    }
}
