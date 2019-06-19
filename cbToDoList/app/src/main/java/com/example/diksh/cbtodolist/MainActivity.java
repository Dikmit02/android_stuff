package com.example.diksh.cbtodolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button add_button;
    ArrayList<String> text_string= new ArrayList<>();
    RecyclerView recyclerView;
    TextRecycleAdapter textRecycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        add_button=findViewById(R.id.add_button);




        recyclerView=findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

         textRecycleAdapter=new TextRecycleAdapter(text_string);
        recyclerView.setAdapter(textRecycleAdapter);






        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_string.add(editText.getText().toString());
                textRecycleAdapter.notifyItemInserted(text_string.size()-1);




            }
        });


    }


}
