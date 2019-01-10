package com.example.health_tracker;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    TextView SmashCounter;
    Button notification;
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

    public void addToCounterOnClick(View v){
        counter ++;
        SmashCounter.setText(Integer.toString(counter));
    }

    public void takeMeToStopwatch(View v){
        Intent headingToStopwatch = new Intent(this, stopwatch.class);
        startActivity(headingToStopwatch);
    }

    public void sendNotification (View v){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Health Tracker")
                .setContentText("Testing text")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Testing bigger Text"))
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