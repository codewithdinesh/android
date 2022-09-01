package in.exp.bluetoothonoff;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.*;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Button on, off, pair, visible;
    ListView devices;
    BluetoothAdapter bluetoothAdapter;
    Set<BluetoothDevice> bluetoothDevices;
    int REQUEST_CODE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        on = findViewById(R.id.on);
        off = findViewById(R.id.off);
        pair = findViewById(R.id.pair);
        visible = findViewById(R.id.visible);
        devices = findViewById(R.id.devices);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // On Bluetooth
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!bluetoothAdapter.isEnabled()) {
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);

                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

                        startActivityForResult(intent, REQUEST_CODE);
                        Toast.makeText(MainActivity.this, "BlueTooth Turned On", Toast.LENGTH_SHORT).show();
                        return;
                    }

                } else {
                    Toast.makeText(MainActivity.this, "BlueTooth already on", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // OFF bluetooth
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bluetoothAdapter.isEnabled()) {
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        bluetoothAdapter.disable();
                        Toast.makeText(MainActivity.this, "Bluetooth OFF", Toast.LENGTH_SHORT).show();
                        return;
                    }

                } else {

                    Toast.makeText(MainActivity.this, "Bluetooth already OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // visible
        visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_ADVERTISE) != PackageManager.PERMISSION_GRANTED) {
                    Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(i, REQUEST_CODE);
                    return;
                }

            }
        });

        pair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    bluetoothDevices = bluetoothAdapter.getBondedDevices();
                    ArrayList ar = new ArrayList();

                    for (BluetoothDevice bluetoothDevice : bluetoothDevices) {

                        ar.add(bluetoothDevice.getAddress());

                    }
                    Toast.makeText(MainActivity.this, "Pair Devices : " + ar, Toast.LENGTH_SHORT).show();
                    ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, ar);
                    devices.setAdapter(arrayAdapter);
                    return;
                }
            }
        });

    }
}