package com.sensorlist;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Sensor sensor;
    SensorManager sensorManager;
    List<Sensor> sensorList;
    ListView listSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listSensor = findViewById(R.id.listOfSensor);
        sensorManager = (SensorManager) MainActivity.this.getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ALL);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        ArrayList ar = new ArrayList();
        for (Sensor i : sensorList) {
            ar.add(i);
            // i.getName() + " : " + i.getVendor() + " : " + i.getVersion()
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, ar);
        listSensor.setAdapter(arrayAdapter);
    }
}