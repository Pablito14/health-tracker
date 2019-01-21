package com.example.health_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Date;
import java.util.List;

public class ExerciseActivity extends AppCompatActivity {

    ExerciseDatabase db;
    ListView databaseListView;
    EditText exerciseTitle, exerciseReps, exerciseDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        //Thank you to Kevin Rosales, Nick Crain, for the help on the allowMainThreadQueries & the fallBackToDestructiveMigration method chaining.
        db = Room.databaseBuilder(getApplicationContext(), ExerciseDatabase.class, "Exercises").allowMainThreadQueries().fallbackToDestructiveMigrationFrom().build();

        if (db.getExerciseDao().getAllExercises().isEmpty()) {
        /*seeding data ONCE*/
        Date now = new Date();
        String timeStamp = now.toString();
        Exercise e = new Exercise("Bicep curl", "10", "Down all the way, up all the way, slow & deep", timeStamp);
        Exercise f = new Exercise("Squat with weights", "10", "Down all the way, up all the way, slow & deep", timeStamp);
        Exercise g = new Exercise("Pushup", "30", "Down to 90 degrees, up all the way, slowly", timeStamp);
        db.getExerciseDao().addExercise(e);
        db.getExerciseDao().addExercise(f);
        db.getExerciseDao().addExercise(g);
        }

        /*uncomment to delete all on view creation*/
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

    public void saveExercise (View v){


        /*Grabbing the users input*/
        final EditText titleField = (EditText) findViewById(R.id.exerciseField);
        final EditText repField = (EditText) findViewById(R.id.unitField);
        final EditText descriptionField = (EditText) findViewById(R.id.descriptionField);

        Date now = new Date();

        /*Setting up information to be recorded in the appropriate format*/
        String title = titleField.getText().toString();
        String reps = repField.getText().toString();
        String description = descriptionField.getText().toString();
        String timestamp = now.toString();

        Exercise usersExercise = new Exercise(title, reps, description, timestamp);

        db.getExerciseDao().addExercise(usersExercise);
        //render new exercise into existing view
    }

}
