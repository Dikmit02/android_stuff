package com.example.beuintern;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapterHori extends RecyclerView.Adapter<RecyclerAdapterHori.RecyclerHolder> {
ArrayList<DataObjForHorizontal> lists;
LayoutInflater mLayoutInflate;

    public RecyclerAdapterHori(ArrayList<DataObjForHorizontal> lists, Context context) {
        this.lists = lists;
        mLayoutInflate = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public RecyclerAdapterHori.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflate.inflate(R.layout.custom_layout, viewGroup, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterHori.RecyclerHolder recyclerHolder, int i) {
    DataObjForHorizontal objs = lists.get(i);
    recyclerHolder.img.setImageResource(objs.getImgResource());
    recyclerHolder.txt.setText(objs.getTitle());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iconImage);
            txt = itemView.findViewById(R.id.textTitle);
        }


    }
}
