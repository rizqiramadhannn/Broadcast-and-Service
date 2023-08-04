package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.services.MyBackgroundService;
import com.example.myapplication.services.MyForegroundService;

public class SecondActivity extends AppCompatActivity {

    private TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent serviceIntent = new Intent(this, MyForegroundService.class);
        startService(serviceIntent);
        Intent backgroundService = new Intent(this, MyBackgroundService.class);
        startService(backgroundService);

        displayTextView = findViewById(R.id.displayTextView);

        Intent intent = getIntent();
        String userInput = intent.getStringExtra("userInput");

        if (userInput != null) {
            displayTextView.setText(userInput);
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        stopService(new Intent(this, MyForegroundService.class));
    }
}
