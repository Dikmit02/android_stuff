package com.example.diksh.cbstaticfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CountDownFragment extends Fragment {


    public CountDownFragment() {
        // Required empty public constructor
    }
    int count = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentview=inflater.inflate(R.layout.fragment_count_up, container, false);
        Button btnAdd=(Button) fragmentview.findViewById(R.id.btnadd);
        final TextView tvCounter=(TextView)fragmentview.findViewById(R.id.tvCounter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                tvCounter.setText(String.valueOf(count));



            }
        });
        return fragmentview;   }

}
