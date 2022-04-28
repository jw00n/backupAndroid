package com.example.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ex2220310.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    ArrayList<MovieVO> list=new ArrayList<>();
    Context context;
    LayoutInflater inflater;
    OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context=parent.getContext();
        inflater=(LayoutInflater) context.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
        //ctrl space
        View view =inflater.inflate(R.layout.movie_item,parent,false);
        MovieViewHolder vh = new MovieViewHolder(view, listener);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.getImgPoster().setImageResource(list.get(position).getPoster());

    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    public void addItem(MovieVO vo){
        list.add(vo);
    }

    public  MovieVO getItem(int pos){
        return list.get(pos);
    }
}
