package com.example.health_tracker;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//Much credit goes to the Android docs(https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#6) and Zahra Mohamed for having her code up for code review

@Database(entities = {Exercise.class}, version = 1)
public abstract class ExerciseDatabase extends RoomDatabase {

    public abstract ExerciseDAO getExerciseDao();

}
