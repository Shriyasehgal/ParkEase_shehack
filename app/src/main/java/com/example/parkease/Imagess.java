
package com.example.parkease;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;



public class Imagess extends AppCompatActivity {
    String[] array={};
    AsyncTask<String, Void, String> s=null;
    Button button;
    String code;
    Button button2;
    Button car1,car2,car3,car4,car5,car6,car7,car8,car9;
    private final long start=System.currentTimeMillis();
    // ImageView imageView;
    // private static final String TAG =URL.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagess);
        Intent intent=getIntent();
        code=intent.getStringExtra("qr");
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("code",code);
        editor.commit();
        ImageView imageView=findViewById(R.id.imageview);
        button=findViewById(R.id.btn1);
        button2=findViewById(R.id.navigation);
       car1=findViewById(R.id.car1);
      car2=findViewById(R.id.car2);
        car3=findViewById(R.id.car3);
        car4=findViewById(R.id.car4);
        car5=findViewById(R.id.car5);
        car6=findViewById(R.id.car6);
        car7=findViewById(R.id.car7);
        car8=findViewById(R.id.car8);
       car9=findViewById(R.id.car9);

        switch (code)
        {
            case "aa":car1.setVisibility(View.VISIBLE);
            break;
            case "ss":car2.setVisibility(View.VISIBLE);
            break;
            case "saloni":car3.setVisibility(View.VISIBLE);
            break;
            case "modi":car3.setVisibility(View.VISIBLE);
            break;
            case "aaryash":car3.setVisibility(View.VISIBLE);
            break;
            case "shriya":car3.setVisibility(View.VISIBLE);
            break;
            case "avani":car3.setVisibility(View.VISIBLE);
            break;
        }
        url3 ur = new url3(Imagess.this);
        try{
            s=ur.execute("https://99smodi.000webhostapp.com/saloni/slot_generation.php?value="+code);

            // Log.d(TAG,s);
        }catch(Exception IO){}

        button2.setOnClickListener(new View.OnClickListener()
        {

            url4 ur = new url4(Imagess.this);
            public void onClick(View view)
            {

                try{

                    s=ur.execute("https://99smodi.000webhostapp.com/saloni/latitude.php?value="+code);

                    // Log.d(TAG,s);
                }catch(Exception IO){}


            }
        });
        button.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {



                Intent inten=new Intent(Imagess.this,Nescafe.class);
                inten.putExtra("qr",code);
                inten.putExtra("start",start);
                startActivity(inten);
            }
        });


    }
}


