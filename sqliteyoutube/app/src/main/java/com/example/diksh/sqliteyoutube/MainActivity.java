package com.example.diksh.sqliteyoutube;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    EditText editTextmarks,editTextsurname,editTextname,editTextid;
    Button button_add,buttonviewall,buttonupdate,buttondelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new DatabaseHelper(this);
        editTextname=findViewById(R.id.editTextname);
        editTextsurname=findViewById(R.id.editTextsurnmae);
        editTextmarks=findViewById(R.id.editTextmarks);
        editTextid=findViewById(R.id.editTextid);
        button_add=findViewById(R.id.button_add);
        buttonviewall=findViewById(R.id.buttonviewall);
        buttonupdate=findViewById(R.id.buttonupdate);
        buttondelete=findViewById(R.id.buttondelete);

        button_add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean ifinserted= mydb.insertData(editTextname.getText().toString(),editTextsurname.getText().toString(),editTextmarks.getText().toString());
                        if(ifinserted==true){
                            Toast.makeText(MainActivity.this, "Data is inserted", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Data is not inserted", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
        );

        buttonviewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res= mydb.getAllData();
                if(res.getCount()==0){
                    showMessage("Error","Nothing Found");
                    return;
                }
                StringBuffer buffer =new StringBuffer();

                while(res.moveToNext()){
                    buffer.append("ID:"+res.getString(0)+"\n");
                    buffer.append("NAME:"+res.getString(1)+"\n");
                    buffer.append("SURNAME:"+res.getString(2)+"\n");
                    buffer.append("MARKS:"+res.getString(3)+"\n\n");

                }
                //show data
                showMessage("Data",buffer.toString());

            }
        });
        buttonupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isupadtes=mydb.updateData(editTextid.getText().toString(),editTextname.getText().toString(),editTextsurname.getText().toString(),editTextmarks.getText().toString());
                if(isupadtes==true){
                    Toast.makeText(MainActivity.this, "Data is updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Data is not updated", Toast.LENGTH_SHORT).show();

                }


            }
        });
        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer deletedrows= mydb.deleteData(editTextid.getText().toString());
                if(deletedrows>0){
                    Toast.makeText(MainActivity.this, "Data is deleted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Data is not deleted", Toast.LENGTH_SHORT).show();


                }
            }
        });

    }

     public void showMessage(String title,String Message){
         AlertDialog.Builder builder=new AlertDialog.Builder(this);
         builder.setCancelable(true);
         builder.setTitle(title);
         builder.setMessage(Message);
         builder.show();
     }



}
