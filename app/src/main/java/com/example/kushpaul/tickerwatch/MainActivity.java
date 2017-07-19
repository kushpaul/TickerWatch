package com.example.kushpaul.tickerwatch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn =(Button)findViewById(R.id.buttonA);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, ListViewer.class));
            }
        });
        Button btn1 =(Button)findViewById(R.id.buttonB);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, PagerActivity.class));
            }
        });
        Button btn2 =(Button)findViewById(R.id.buttonC);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, DialogActivity.class));
            }
        });
        Button btn3 =(Button)findViewById(R.id.buttonD);
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, AnimationActivity.class));
            }
        });
    }

    TextView tv;
    int x;
    Random rand = new Random();
    String num;
    Handler hand = new Handler();

    public void Handle(View view){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                generateNumber();
            }
        };
        new Thread(runnable).start();
    }

    private void generateNumber() {
        for(int i=0;i<=40;i++){
            x = rand.nextInt(100)+1;
            num = String.valueOf(x);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hand.post(new Runnable(){
                @Override
                public void run(){
                    tv=(TextView)findViewById(R.id.tex);
                    tv.setText(num);
                }
            });
        }
    }
}
