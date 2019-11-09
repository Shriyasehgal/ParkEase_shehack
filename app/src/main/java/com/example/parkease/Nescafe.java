package com.example.parkease;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by user on 16-02-2018.
 */
//import java.net.URL;


public class Nescafe extends AppCompatActivity {
    String[] array={};
    AsyncTask<String, Void, String> s=null;
    String code;
    long start;
    // ImageView imageView;
    // private static final String TAG =URL.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nescafe);
        Intent intent=getIntent();
        code=intent.getStringExtra("qr");
        start=intent.getLongExtra("start",0);
        Context mcontext=this;
        //TextView textView=(TextView)findViewById(R.id.text);
       // TextView textView=findViewById(R.id.text);
        ImageView imageView=findViewById(R.id.imageview);
        Button button=findViewById(R.id.btn1);
//        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putInt(getString(R.string.save), code);
//        editor.commit();
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent1=new Intent(Nescafe.this,Exit.class);
                 intent1.putExtra("qr",code);
                 intent1.putExtra("start",start);
                 startActivity(intent1);
             }
         });
        //listView.setAdapter(adapter);
        url ur = new url(Nescafe.this,imageView);
        // TextView textView=(TextView)findViewById(R.id.text);
        try{

            //s=ur.execute("http://192.168.43.200/docs/saloni1.php").get();
            s=ur.execute("https://99smodi.000webhostapp.com/saloni/img_qr.php?value="+code);
          /*  button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //   s=ur.execute("https://99smodi.000webhostapp.com/saloni/exit.php?value=");
                    Intent inten=new Intent(Nescafe.this,Exit.class);
                    startActivity(inten);
                }
            });*/
            // Log.d(TAG,s);
        }catch(Exception IO){}





    }
}
