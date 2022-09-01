package in.exp.connectionbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class ConnectionReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("status", "Hello " + intent.getAction());

        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (info != null && info.isAvailable() && info.isConnectedOrConnecting()) {
                Toast.makeText(context, "Network is Connected", Toast.LENGTH_SHORT).show();

                if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                    Toast.makeText(context, "Its Wifi", Toast.LENGTH_SHORT).show();
                }
                if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                    Toast.makeText(context, "Its Mobile Data", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(context, "No network is connected", Toast.LENGTH_LONG).show();
            }

        } else if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {

            // check bluetooth
            if (Settings.System.getInt(context.getContentResolver(), Settings.System.BLUETOOTH_ON, 0) == 0) {
                Toast.makeText(context, "Bluetooth is OFF", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Bluetooth is On", Toast.LENGTH_SHORT).show();
            }

        } else if (intent.getAction().equals("android.intent.action.AIRPLANE_MODE")) {
            // check airplane mode
            if (Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) == 0) {
                Toast.makeText(context, "Airplane Mode is Off", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Airplane Mode is On", Toast.LENGTH_SHORT).show();
            }
        } else if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
            Toast.makeText(context, "Battery Percentage Changed", Toast.LENGTH_SHORT).show();
        }
    }
}
