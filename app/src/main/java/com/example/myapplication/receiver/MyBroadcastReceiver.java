package com.example.myapplication.receiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;
import android.net.ConnectivityManager;

import androidx.core.app.NotificationCompat;

import com.example.myapplication.R;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("BroadcastExample", "Custom broadcast received!");
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            // Create a notification channel for Android Oreo and higher
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("mychannel_id", "My Channel", NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
            }

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "mychannel_id")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("Boot Notification")
                    .setContentText("This is Boot Complete notification.")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            Notification notification = builder.build();
            notificationManager.notify(1, notification);
        }
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            // Create a notification channel for Android Oreo and higher
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("mychannel_id", "My Channel", NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
            }

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "mychannel_id")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("Connectivity Notification")
                    .setContentText("This is Connectivity notification.")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            Notification notification = builder.build();
            notificationManager.notify(1, notification);
        }
    }
}
