package com.example.recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ex2220310.R;

import java.util.ArrayList;

public class MyAdapter  extends RecyclerView.Adapter<MyViewHolder>{

    ArrayList<String> dataset;
    OnItemClickListener clickListener;

    public MyAdapter(ArrayList<String> dataset) {
        this.dataset = dataset;
    }

    //아이템 클릭 이벤트 객체 초기화 ->> MyViewHolder 클래스내에서 호출 -> 초기화
    public void setOnItemClickListener(OnItemClickListener clickListener){
        this.clickListener=clickListener;

    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //parent 객체 -> recyclerView 라고 봐도
        // parent.getContext() -> RecyclerViewAcctivity 화면 정보
        Context context = parent.getContext();

        //list_item.xml 파일을 view 갹체로 ㅜ 변환하는 작업이 일어나야
        //화면에출력가능하다
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                                                        Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.list_item, parent , false);

        //View 객체 (list_item.xml)와 아이템 클릭이벤트 객체를 MyViewHolder객체에 전달.
        MyViewHolder holder = new MyViewHolder(view,clickListener);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.getTextView().setText(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
