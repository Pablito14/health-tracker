package com.example.health_tracker;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Much credit goes to the Android docs(https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#3) and Zahra Mohamed for having her code up for code review

@Entity
public class Exercise {

    /*Instance variables*/

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "nameOfExercise")
    public String nameOfExercise;

    @ColumnInfo(name = "reps")
    public String reps;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "timeStamp")
    public String timeStamp;

    //Default constructor
    public Exercise (){}

    //Real constructor
    public Exercise (String nameOfExercise, String reps, String description, String timeStamp){
        this.nameOfExercise = nameOfExercise;
        this.reps = reps;
        this.description = description;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString(){
        return "Exercise: " + this.nameOfExercise + ", Reps: " + this.reps + ", Description: " + this.description + ", Completed on: " + this.timeStamp;
    }

}
