package com.example.parkease;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_Screen extends AppCompatActivity {
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
       thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(2600);
                    Intent intent=new Intent(Splash_Screen.this,MainActivity.class);
                    startActivity(intent);

                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }

            }
        };
        thread.start();

    }
}
