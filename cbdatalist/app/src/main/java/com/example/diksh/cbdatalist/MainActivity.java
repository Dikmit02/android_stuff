package com.example.diksh.cbdatalist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> todos=new ArrayList<>();
    ArrayAdapter<String> todoAdapter;
    Button btnaddtodo;
    EditText etNewToDo;
    ListView lvTodos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnaddtodo=findViewById(R.id.btnaddtodo);
        etNewToDo=findViewById(R.id.etNewToDo);
        lvTodos=findViewById(R.id.lvTodos);
        todoAdapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,todos
        );
        lvTodos.setAdapter(todoAdapter);
        btnaddtodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                todos.add(etNewToDo.getText().toString());

                todoAdapter.notifyDataSetChanged();

            }
        });






    }
}
