package com.example.ex03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String channelId = "Notification Channel";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button); //Button that starts up the notifications

        createNotificationChannel();

        button.setOnClickListener(view -> {
            Notification_Service.doActionNotification(MainActivity.this);

            Toast.makeText(MainActivity.this, "Notifications Activated ", Toast.LENGTH_LONG).show(); //when button is pressed, notifications start
        } );

    }

    //Start up the notification Channel
    protected void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);

            notificationManager.createNotificationChannel(new NotificationChannel(channelId, channelId, NotificationManager.IMPORTANCE_DEFAULT));
        }
    }

    }
