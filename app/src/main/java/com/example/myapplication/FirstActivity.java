package com.example.myapplication;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.receiver.MyBroadcastReceiver;

public class FirstActivity extends AppCompatActivity {

    private EditText editText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyBroadcastReceiver myReceiver = new MyBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.myapplication.CUSTOM_BC");
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGED");
        registerReceiver(myReceiver, filter);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        editText = findViewById(R.id.editText);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = editText.getText().toString();
                Intent customBroadcastIntent = new Intent("com.example.myapplication.CUSTOM_BC");
                sendBroadcast(customBroadcastIntent);
                Log.i("TAG", "onClick: " + customBroadcastIntent + "Sebelum dikirim");
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("userInput", userInput);
                startActivity(intent);
            }
        });
    }
}
