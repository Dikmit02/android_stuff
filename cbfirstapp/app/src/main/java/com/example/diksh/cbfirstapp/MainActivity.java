package com.example.diksh.cbfirstapp;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button zero,one,two,three,four,five,six,seven,nine,eight,plus,minus,multiply, divide,clear,equalto;
    TextView getnumber;
    int i=0;
    double var;
    double p=0;
    String str="",sign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getnumber=(TextView)findViewById(R.id.getnumber);
        zero=(Button)findViewById(R.id.zero) ;
        one=(Button)findViewById(R.id.one);
        two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);
        four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.five);
        six=(Button)findViewById(R.id.six);
        seven=(Button)findViewById(R.id.seven);
        nine=(Button)findViewById(R.id.nine);
        eight=(Button)findViewById(R.id.eight);
        plus=(Button)findViewById(R.id.plus);
        minus=(Button)findViewById(R.id.minus);
        multiply=(Button)findViewById(R.id.multiply);
        divide=(Button)findViewById(R.id.divide);
        equalto=(Button)findViewById(R.id.equalto);
        clear=(Button)findViewById(R.id.clear);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equalto.setOnClickListener(this);
        clear.setOnClickListener(this);







    }

    @Override
    public void onClick(View v) {
        String ss="";


        Button b = (Button) v;
        i= Integer.parseInt((b.getTag().toString()));
           if(i==1) {
            ss=b.getText().toString();
            str =str+ss;
            getnumber.setText(str);
            var=Double.parseDouble(str);



         }

           else if(i==2){

                p+=var;
                str="";
                getnumber.setText(str);
                sign="+";


                //Toast.makeText(this, String.valueOf(p), Toast.LENGTH_SHORT).show();
            }
            else if(i==3){
                //var=Double.parseDouble(str);
                p=p-var;
                str="";
               getnumber.setText(str);
               sign="-";

                //  Toast.makeText(this, String.valueOf(p), Toast.LENGTH_SHORT).show();
            }
            else if(i==4){
                //var=Double.parseDouble(str);
                if(p==0){
                    p=1;
                }
                p=var*p;
                str="";
               getnumber.setText(str);
               sign="*";

                //    Toast.makeText(this, String.valueOf(p), Toast.LENGTH_SHORT).show();
            }
            else if(i==5){
                //var=Double.parseDouble(str);
               if(p==0){
                   p=1;
               }
                p=var/p;
               str="";
               getnumber.setText(str);
               sign="/";

                //Toast.makeText(this, String.valueOf(p), Toast.LENGTH_SHORT).show();

            }
            else if(i==6){

                getnumber.setText("");
                p=0;
                i=1;
                str="";
           }
            else if(i==7){
                //var=Double.parseDouble(str);
                if(sign.equals("+")){
                    var+=p;
                }
                if(sign.equals("-")){
                   var=var-p;
               }
                if(sign.equals("*")){
                   var=var*p;
               }
               if(sign.equals("/")){
                   var=var/p;
               }
               getnumber.setText(String.valueOf(var));
               p=var;
            }




    }
}





 /* if(i==1) {
            ss=b.getText().toString();
            str =str+ss;
            getnumber.setText(str);
            p=Integer.parseInt(str);



        }
        else if (i==2||i==3||i==4||i==5) {

            sign = ((Button) v).getText().toString();
            calculate(p,sign);



        }
        else{

            calculate(p,sign);
        }




    }
    public void calculate(String ans,String op){

        if(op.equals("+")){

        }

*/