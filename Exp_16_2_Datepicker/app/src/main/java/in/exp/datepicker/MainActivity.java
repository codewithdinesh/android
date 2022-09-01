package in.exp.datepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    EditText editText1, editText2;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.Btn1);
        btn2 = findViewById(R.id.Btn2);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);
                datePickerDialog = new DatePickerDialog(MainActivity.this);
                datePickerDialog.show();
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Toast.makeText(MainActivity.this, i2 + "/" + i1 + "/" + i, Toast.LENGTH_SHORT).show();
                        editText1.setText(i2 + "/" + i1 + "/" + i);
                    }
                });
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int hr = c.get(Calendar.HOUR);
                int min = c.get(Calendar.MINUTE);
                timePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Toast.makeText(MainActivity.this, i + " : " + i1, Toast.LENGTH_SHORT).show();
                        editText2.setText(i + " : " + i1);
                    }
                }, hr, min, false);
                timePicker.show();
            }
        });
    }
}