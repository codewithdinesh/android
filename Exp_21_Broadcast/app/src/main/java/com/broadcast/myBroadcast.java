package com.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class myBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Toast.makeText(context, "Namaste", Toast.LENGTH_SHORT).show();

        Log.d("api 123 ", "Broadcast started " + intent.getAction());

        if (intent.getAction().equals("https://drustii.in/")) {
            Toast.makeText(context, "Some Action are received", Toast.LENGTH_SHORT).show();
        } else {

            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
                    Toast.makeText(context, "Network is connected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Network is not connected, Change Network or reconnect", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
