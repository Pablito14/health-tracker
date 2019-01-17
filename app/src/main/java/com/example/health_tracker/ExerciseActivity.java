package com.example.health_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import java.util.Date;

public class ExerciseActivity extends AppCompatActivity {

    ExerciseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        db = Room.databaseBuilder(getApplicationContext(), ExerciseDatabase.class, "Exercises").build();
        Exercise e = new Exercise("squat", "20", "Down to 90 degrees", "nowish");
        db.getExerciseDao().addExercise(e);
        db.getExerciseDao().getAllExercises();
    }

    public void saveExercise(Exercise e){
        db.getExerciseDao().addExercise(e);
    }


}
