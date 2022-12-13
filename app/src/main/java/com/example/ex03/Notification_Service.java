package com.example.ex03;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class Notification_Service extends IntentService {

    private static final long FIVE_MINUTES = 10 * 1000;

    private static AlarmManager alarmManager = null;

    private static PendingIntent pendingIntent = null;

    public Notification_Service() {

        super("Notification Service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();

            if ("com.example.ex03.action.NOTIFICATION".equals(action)) {
                handleActionNotification();
            }

            else {
                throw new RuntimeException("Unknown Action");
            }
        }
    }

    public void onCreate(){
        super.onCreate();
        Log.d("Notification Service", "Successful Creation of Notification Service");
    }

    public static void doActionNotification(Context context){
        Intent intent = new Intent(context, Notification_Service.class);

        intent.setAction("com.example.ex03.action.NOTIFICATION");
        context.startService(intent);
    }

    private void handleActionNotification() {

        if (pendingIntent == null) {
            Intent intent = new Intent(this, Notification_receiver.class);

            pendingIntent = (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) ?
                    PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE) :

                    PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

            alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis(),
                    FIVE_MINUTES,
                    pendingIntent);

            Log.d("Notification Service", "Successful Creation of Alarm Manager");
        }

    }
}
