package com.example.parkease;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by user on 16-02-2018.
 */
//import java.net.URL;


public class Exit extends AppCompatActivity {
    String[] array={};
    AsyncTask<String, Void, String> s=null;
    Button button;
    String code;
    long start;
    long pay;
    // ImageView imageView;
    // private static final String TAG =URL.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        TextView textView=(TextView)findViewById(R.id.Text12);
        TextView txt=(TextView)findViewById(R.id.Text13) ;
        Intent intent=getIntent();
        code=intent.getStringExtra("qr");
        start=intent.getLongExtra("start",0);
        long time=System.currentTimeMillis()-start;
        long runtime=time/(3600*1000);
        if(runtime<=3)
            pay=30;
        else if(runtime<=6)
                pay=30+(runtime-3)*20;
        else
            pay=100;
        txt.setText(Long.toString(pay));

        button=findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url2 ur = new url2(Exit.this);
                // TextView textView=(TextView)findViewById(R.id.text);
                try{

                    //s=ur.execute("http://192.168.43.200/docs/saloni1.php").get();
                    s=ur.execute("https://99smodi.000webhostapp.com/saloni/exit.php?value="+code);

                    // Log.d(TAG,s);
                }catch(Exception IO){}

               onBackPressed();


            }
        });//listView.setAdapter(adapter);


    }
    public void onBackPressed() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}

