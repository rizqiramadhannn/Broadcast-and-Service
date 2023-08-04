package com.example.myapplication.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

// MyBackgroundService.java
// MyBackgroundService.java
public class MyBackgroundService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Simulate downloading a file from a remote server
        // Replace this with actual download logic
        downloadFile();

        stopSelf(); // Stop the service after the task is done

        return START_NOT_STICKY;
    }

    private void downloadFile() {
        // Simulate downloading a file
        try {
            Thread.sleep(5000); // Simulate a 5-second download
            Toast.makeText(this, "Download Finish", Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
