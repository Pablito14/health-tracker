package com.example.health_tracker;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


//Much credit goes to the Android docs(https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#4) and Zahra Mohamed for having her code up for code review

@Dao
public interface ExerciseDAO {

    //add one exercise
    @Insert
    void addExercise(Exercise exercise);

    //delete one exercise
    @Delete()
    void delete(Exercise exercise);

    //select one exercise
    @Query("SELECT * FROM exercise WHERE id=:id")
    Exercise getById(long id);

    //update and exercise
    @Update
    void update(Exercise exercise);

    //delete all exercises
    @Query("DELETE FROM exercise")
    void deleteAll();

    //select all exercises
    @Query("SELECT * FROM exercise ORDER BY nameOfExercise ASC")
    LiveData<List<Exercise>> getAllExercises();
}
