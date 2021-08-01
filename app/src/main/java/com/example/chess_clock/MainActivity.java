package com.example.chess_clock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> data=new ArrayList<Integer>();
    EditText Hour,Minute,Second,Increment;
    String hour,min,sec,inc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hour=findViewById(R.id.Hour);
        Minute=findViewById(R.id.Minute);
        Second=findViewById(R.id.Second);
        Increment=findViewById(R.id.Increment);
    }
    public void go(View view)
    {
        hour=Hour.getText().toString();
        min=Minute.getText().toString();
        sec=Second.getText().toString();
        inc=Increment.getText().toString();
        if(hour.equalsIgnoreCase(""))
            hour="0";
        if(min.equalsIgnoreCase(""))
            min="0";
        if(sec.equalsIgnoreCase(""))
            sec="0";
        if(inc.equalsIgnoreCase(""))
            inc="0";
        data.add(Integer.parseInt(hour));
        data.add(Integer.parseInt(min));
        data.add(Integer.parseInt(sec));
        data.add(Integer.parseInt(inc));
        data.add(Integer.parseInt(hour));
        data.add(Integer.parseInt(min));
        data.add(Integer.parseInt(sec));
        data.add(Integer.parseInt(inc));

        Intent intent =new Intent(this,MainActivity2.class);
        intent.putIntegerArrayListExtra("key",data);
        startActivity(intent);

    }


}