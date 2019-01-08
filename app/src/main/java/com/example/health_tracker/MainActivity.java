package com.example.health_tracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    TextView SmashCounter;
    public int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SmashCounter = findViewById(R.id.counter);
    }

    public void addToCounterOnClick(View v){
        counter ++;
        SmashCounter.setText(Integer.toString(counter));
    }
}
