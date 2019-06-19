package com.example.diksh.cbdynamicfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class VegetableFragment extends Fragment {


    public VegetableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View fragment=inflater.inflate(R.layout.fragment_vegetable, container, false);
        ArrayList<String> veg=new ArrayList<>();
        veg.add("potato");
        veg.add("tomato");
        veg.add("carrot");
        veg.add("brinjal");
        veg.add("cauliflower");
        veg.add("cabbage");
        veg.add("lady finger");
        veg.add("carrot");

        ListView listview=(ListView)fragment.findViewById(R.id.lvlist);

        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(
                fragment.getContext(),
                android.R.layout.simple_list_item_1,
                veg);
        listview.setAdapter(arrayAdapter);


        return  fragment;
    }

}
