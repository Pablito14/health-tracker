package com.example.health_tracker;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button notification;
    TextView SmashCounter;
    public int counter = 0;
    public int notificationID = 0;
    private static final String CHANNEL_ID = "channelid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SmashCounter = findViewById(R.id.counter);
        notification = findViewById(R.id.notification);
        createNotificationChannel();
    }

    // Credit goes to Mason Basset for the original work, & and Michelle Ferreirae for reviewing as well as optimizing
    public void addToCounterOnClick(View v){
        counter ++;
        SmashCounter.setText(Integer.toString(counter));
//        String everyTwentyClicks = "Go Forest, its ya birthday, go, go, go, go.";
//        String everyFiftyyClicks = "Dayyyyyyyyyyyyyyyum";
//        String currentCountString = counter.toString();
//        if (counter % 50 == 0){
//            currentCountString += everyFiftyyClicks;
//        }else if(counter % 20 == 0){
//            currentCountString += everyTwentyClicks;
//        }

    }

    public void takeMeToStopwatch(View v){
        Intent headingToStopwatch = new Intent(this, StopwatchActivity.class);
        startActivity(headingToStopwatch);
    }

    public void takeMeToFingercises(View v){
        Intent headingToFingercises = new Intent(this, FingercisesActivity.class);
        startActivity(headingToFingercises);
    }

    public void takeMeToExerciseDiary(View v){
        Intent headingToExerciseDiary= new Intent(this, ExerciseActivity.class);
        startActivity(headingToExerciseDiary);
    }

    public void sendNotification (View v){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Health Tracker")
                .setContentText("Drink some water!")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("IT'S DEHYDRATION!"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationID ++, mBuilder.build());
    }

    // From Android Docs (https://developer.android.com/training/notify-user/channels#java)
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = CHANNEL_ID;
//            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
//            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}