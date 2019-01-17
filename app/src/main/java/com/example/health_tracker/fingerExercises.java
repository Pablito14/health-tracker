package com.example.health_tracker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class fingerExercises extends AppCompatActivity {

    TextView SmashCounter;
    public int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_exercises);
        SmashCounter = findViewById(R.id.counter);
    }

    public void addToCounterOnClick(View v) {
        counter++;
        SmashCounter.setText(Integer.toString(counter));
    }
}
