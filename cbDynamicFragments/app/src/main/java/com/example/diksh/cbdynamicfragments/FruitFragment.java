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
public class FruitFragment extends Fragment {




    public FruitFragment() {
        // Required empty public constructor



    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View fragment=inflater.inflate(R.layout.fragment_fruit, container, false);
        ArrayList<String>fruits=new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");
        fruits.add("Kiwi");
        fruits.add("Pineapple");
        fruits.add("Pear");
        fruits.add("Guava");

        fruits.add("Lichi");

        //String [] fruits={"Apple","Orange","Banana"};

        ListView listview=(ListView)fragment.findViewById(R.id.lvlist);

        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(
                fragment.getContext(),
                android.R.layout.simple_list_item_1,
                fruits);
        listview.setAdapter(arrayAdapter);

        return fragment;
    }

}
