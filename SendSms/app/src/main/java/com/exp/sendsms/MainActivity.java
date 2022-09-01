package com.exp.sendsms;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText phoneNum, msg;
    Button sendSms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendSms = findViewById(R.id.sendSms);
        phoneNum = findViewById(R.id.phone);
        msg = findViewById(R.id.msg);


        sendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = phoneNum.getText().toString();
                String Msg = msg.getText().toString();

                //Toast.makeText(MainActivity.this, "phone: "+phone, Toast.LENGTH_SHORT).show();

                try {

                    //Getting intent and PendingIntent instance
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(phone, null, Msg, null, null);

                    Toast.makeText(MainActivity.this, "Sms Send successfully", Toast.LENGTH_SHORT).show();


                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "unsuccessful", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

    }
}