package in.exp.airplainmode;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    AirPlaneBroadReciever airPlaneBroadReciever = new AirPlaneBroadReciever();



    // 2 files - connectionreciever,mainActivity
    // create class
    // connectReciever name

    // mainActivity
    // obj of class
    // obj of intent filter
    // classobj= new class()
    // intentFilter(ConnectivityManager.CONNECTIVITY_ACTION)


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter i = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airPlaneBroadReciever, i);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(airPlaneBroadReciever);
    }
}