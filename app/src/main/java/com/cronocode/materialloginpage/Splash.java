package com.cronocode.materialloginpage;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread splash=new Thread(){
            public void run(){
                try{
                    sleep(3*1000);
                    Intent i=new Intent(getBaseContext(),LogIn.class);
                    startActivity(i);
                    finish();
                }catch (Exception e){}
            }
        };
        splash.start();
    }
}
