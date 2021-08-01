package com.example.chess_clock;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {


    int h,m,s,i,h1,m1,s1,i1;
    boolean running,running1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        ArrayList<Integer> d=intent.getIntegerArrayListExtra("key");
         h=d.get(0);
         m=d.get(1);
         s=d.get(2);
         i=d.get(3);
         h1=d.get(4);
         m1=d.get(5);
         s1=d.get(6);
         i1=d.get(7);
         s=((h*3600)+(m*60)+s);
         s1=((h1*3600)+(m1*60)+s1);
        runtimer();
        runtimer1();



    }
    public void tap1(View view) {
        if(running1!=true && s!=0) {
            s = s + i + 1;
        }
        running=false;
        running1=true;


    }

    public void onStart(View view) {
        if(s1!=0&&s!=0){
        running=true;}
    }
    public void onStop(View view){
        running=false;
        running1=false;
    }

    public void tap2(View view) {
        if(running!=true && s1!=0) {
            s1 = s1 + i + 1;
        }
        running1=false;
        running=true;
    }
    public void onReset(View view){
        s1=0;
        s=0;
        running1=false;
        running=false;
    }
    public void runtimer(){

            final TextView textView = findViewById(R.id.textView);
            final Handler handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    int hr = s / 3600;
                    int mins = (s % 3600) / 60;
                    int secs = s % 60;
                    String time = String.format("%2d:%2d:%d", hr, mins, secs);
                    textView.setText(time);
                    if (running) {
                        if (h != 0 || m != 0 || s != 0) {
                            s--;
                        } else if (s == 0) {
                            onStop();
                        }
                    }
                    handler.postDelayed(this, 1000);
                }
            });




    }
    public void runtimer1(){

            final TextView textView2 = findViewById(R.id.textView2);
            final Handler handler1 = new Handler();
            handler1.post(new Runnable() {
                @Override
                public void run() {
                    int hr1 = s1 / 3600;
                    int mins1 = (s1 % 3600) / 60;
                    int secs1 = s1 % 60;
                    String time1 = String.format("%2d:%2d:%d", hr1, mins1, secs1);
                    textView2.setText(time1);
                    if (running1) {
                        if (h1 != 0 || m1 != 0 || s1 != 0) {
                            s1--;
                        } else if (s1 == 0) {
                            onStop();
                        }
                    }
                    handler1.postDelayed(this, 1000);
                }
            });
        }



    }

