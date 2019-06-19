package com.example.diksh.firstkotlinproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnAdd:Button=findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener(View.OnClickListener {

            Toast.makeText(this@MainActivity,"Hello",Toast.LENGTH_SHORT).show()
        })
    }
}
