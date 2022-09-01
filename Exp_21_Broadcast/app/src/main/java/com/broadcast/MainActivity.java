package com.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// broadcast receiver
// exp 19 20 are not required

public class MainActivity extends AppCompatActivity {
    Button btn;
    myBroadcast myBroadcast;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        myBroadcast = new myBroadcast();
        intentFilter = new IntentFilter("com.broadcast.SOME_ACTION");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.broadcast.SOME_ACTION");
                sendBroadcast(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myBroadcast, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(myBroadcast);

    }
}