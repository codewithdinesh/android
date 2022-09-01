package in.exp.exptimepicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends Activity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimePicker timePicker=findViewById(R.id.clock);

        // set 24 hours view
        timePicker.setIs24HourView(true);

        //disable Time Picker
        // timePicker.setEnabled(false);

        //set default time Hours
        timePicker.setHour(12);
        timePicker.setCurrentHour(14);

        //set default minutes
        timePicker.setMinute(30);


        // change Time Listener
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                Toast.makeText(MainActivity.this, i+" : "+i1, Toast.LENGTH_SHORT).show();
            }
        });
    }
}