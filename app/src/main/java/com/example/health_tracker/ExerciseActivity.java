package com.example.health_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Date;
import java.util.List;

public class ExerciseActivity extends AppCompatActivity {

    ExerciseDatabase db;
    ListView databaseListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        //Thank you to Kevin Rosales, Nicholas Crain, for the help on the allowMainThreadQueries & the fallBackToDestructiveMigration method chaining.
        db = Room.databaseBuilder(getApplicationContext(), ExerciseDatabase.class, "Exercises").allowMainThreadQueries().fallbackToDestructiveMigrationFrom().build();

        /*seeding data*/
//        Exercise e = new Exercise("Bicep curl", "10", "Down all the way, up all the way, slow & deep", "01-18-2019 6: 00PM");
//        Exercise f = new Exercise("Squat with weights", "10", "Down all the way, up all the way, slow & deep", "01-18-2019 6: 05PM");
//        Exercise g = new Exercise("Pushup", "30", "Down to 90 degrees, up all the way, slowly", "01-18-2019 6: 10PM");
//
//        db.getExerciseDao().addExercise(g);

        /*uncomment to delete all*/
//        db.getExerciseDao().deleteAll();

          renderExercisesFromDB();


    }


    //Thank you/credit to Darrin Howell & Tara Johnson for showing me this snippet and explaining the processes going on
    public void renderExercisesFromDB(){
        List<Exercise> exercises = db.getExerciseDao().getAllExercises();
        databaseListView = findViewById(R.id.exerciseList);
        ArrayAdapter<Exercise> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, exercises);
        databaseListView.setAdapter(arrayAdapter);
    }

//    public void saveExercise (View v){
//        Exercise exercise = new Exercise(R.attr.);
//    }

}
