package com.exp.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;


public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        
        Bundle bundle = intent.getExtras();
        Object[] objects = (Object[]) bundle.get("pdus");


        for (Object o : objects) {
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) o);
            String sender = smsMessage.getDisplayOriginatingAddress();
            String message = smsMessage.getMessageBody();


            Toast.makeText(context, "Message Received from " + sender + "\n" + message, Toast.LENGTH_SHORT).show();
        }

    }
}
