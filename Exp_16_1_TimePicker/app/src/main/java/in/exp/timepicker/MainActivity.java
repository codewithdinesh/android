package in.exp.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimePicker timePicker=findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        TimePicker timePicker1=findViewById(R.id.timePicker1);
        timePicker1.setIs24HourView(true);
    }
}