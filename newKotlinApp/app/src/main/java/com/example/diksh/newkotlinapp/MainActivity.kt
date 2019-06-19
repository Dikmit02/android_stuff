package com.example.diksh.newkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnadd.setOnClickListener({

         val tvresult=num1.text.toString().toInt()+num2.text.toString().toInt();
            result.text=tvresult.toString()

        })



    }
}



/* var btnAdd :Button?=null

override fun onCreate(savedInstanceState: Bundle?) {
   super.onCreate(savedInstanceState)
   setContentView(R.layout.activity_main)

   //var btnAdd=findViewById<Button>(R.id.btnadd)

   btnAdd = findViewById(R.id.btnadd)


   /*
  a?b.() in kotlin

  if(a!=null){
    a.b()


    a!!b.() in kotlin

  if(a==null){
    throw null exception

    }
    else{
    a.b()
    }*/


   btnAdd!!.setOnClickListener({
       Toast.makeText(this@MainActivity,"HELLO",Toast.LENGTH_LONG).show();
   })



}*/