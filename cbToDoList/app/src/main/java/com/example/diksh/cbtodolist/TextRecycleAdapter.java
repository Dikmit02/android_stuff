package com.example.diksh.cbtodolist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class TextRecycleAdapter extends RecyclerView.Adapter<TextRecycleAdapter.TextViewHolder> {

    ArrayList<String> list;




    public TextRecycleAdapter(ArrayList<String> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {



        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View itemView=layoutInflater.inflate(R.layout.list_item_text,viewGroup,false );
        return new TextViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(@NonNull TextViewHolder textViewHolder, int i) {
        String text=list.get(i);
        textViewHolder.list_text.setText(text.toString());



  }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TextViewHolder extends RecyclerView.ViewHolder{
        TextView list_text;

        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            list_text=(TextView)itemView.findViewById(R.id.list_text);
        }
    }

}
