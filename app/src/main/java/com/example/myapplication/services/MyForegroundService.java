package com.example.myapplication.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.myapplication.R;

// MyForegroundService.java
// MyForegroundService.java
public class MyForegroundService extends Service {

    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize the MediaPlayer and set a sample audio file
        mediaPlayer = MediaPlayer.create(this, R.raw.sample_music);
        mediaPlayer.setLooping(true); // Loop the audio
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Create a notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("ChannelId", "ChannelName", NotificationManager.IMPORTANCE_DEFAULT);
            // Configure other channel settings

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        // Create a notification for the foreground service
        Notification notification = new NotificationCompat.Builder(this, "ChannelId")
                .setContentTitle("Music Player")
                .setContentText("Playing music...")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .build();

        // Start the service in the foreground with the notification
        startForeground(1, notification);

        // Start playing music
        mediaPlayer.start();
        Log.i("TAG", "onStartCommand: ");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Release the MediaPlayer resources when the service is stopped
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

