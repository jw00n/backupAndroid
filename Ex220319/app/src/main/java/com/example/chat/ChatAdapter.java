package com.example.chat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ex220319.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChayViewHolder> {
    ArrayList<ChatVO> list=new ArrayList<>();
    Context context;
    LayoutInflater inflater;
    String currentId;


    @NonNull
    @Override
    public ChayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        inflater=(LayoutInflater) context.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
        //ctrl space
        View view =inflater.inflate(R.layout.chat_item,parent,false);
        ChayViewHolder vh = new ChayViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ChayViewHolder holder, int position) {

        //아이디를 구분하여 채팅내역을 출력
        //상대방 아이디인 경우 왼쪽 뷰만 출력
        //본인아이디일경우 오른쪽 뷰만


        //여기서 currentId 로 값이 안 들어오는 오류
        if(currentId.equals(list.get(position).getName())){

            holder.getTvMyMsg().setVisibility(View.VISIBLE);
            holder.getTvMyTime().setVisibility(View.VISIBLE);

            //invisble 공간있vs Gone 공간없
            holder.getTvOtherNm().setVisibility(View.GONE);
            holder.getTvOtherMsg().setVisibility(View.GONE);
            holder.getTvOtherTime().setVisibility(View.GONE);
            holder.getImgOther().setVisibility(View.GONE);

            holder.getTvMyMsg().setText(list.get(position).getMsg());
            holder.getTvMyTime().setText(list.get(position).getTime());

        }else{
            holder.getTvOtherNm().setVisibility(View.VISIBLE);
            holder.getTvOtherMsg().setVisibility(View.VISIBLE);
            holder.getTvOtherTime().setVisibility(View.VISIBLE);
            holder.getImgOther().setVisibility(View.VISIBLE);

            holder.getTvMyMsg().setVisibility(View.GONE);
            holder.getTvMyTime().setVisibility(View.GONE);

            holder.getTvOtherNm().setText(list.get(position).getName());
            holder.getTvOtherMsg().setText(list.get(position).getMsg());
            holder.getTvOtherTime().setText(list.get(position).getTime());
            holder.getImgOther().setImageResource(list.get(position).getImgProfile());

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //list에 채팅데이터가 저장될수있도록 메소드 추가
    public void addItem(ChatVO vo){
        list.add(vo);
     }

     //현재 로그인한 id설정 메소드
     public void setCurrentId(String id){
        currentId=id;
     }
}
