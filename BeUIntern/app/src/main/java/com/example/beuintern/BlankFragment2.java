package com.example.beuintern;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class BlankFragment2 extends Fragment {

RecyclerView recycleVerticle,recycleHorizontal;
ArrayList<DataObj> dataObjs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        dataObjs = new ArrayList<>();
        recycleVerticle = view.findViewById(R.id.rec1v);


        // Inflate the layout for this fragment
        return view;
    }


}
