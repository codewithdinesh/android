package in.exp.radiobutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button showBtn;
    RadioButton radioButton1, radioButton2;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButton1 = findViewById(R.id.radioBtn_1);
        radioButton2 = findViewById(R.id.radioBtn_2);
        radioGroup = findViewById(R.id.radioBtnGroups);

        showBtn = findViewById(R.id.showBtn);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkRadio(radioButton1, radioButton2);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if (i == R.id.male) {
                            Toast.makeText(MainActivity.this, "Male", Toast.LENGTH_SHORT).show();
                        } else if (i == R.id.female) {
                            Toast.makeText(MainActivity.this, "Female", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }

    public void checkRadio(RadioButton... checkBox) {
        int i;
        String selectedItem = "";

        for (i = 0; i < checkBox.length; i++) {
            if (checkBox[i].isChecked()) {
                selectedItem += checkBox[i].getText().toString() + " ";
            }
        }
        Toast.makeText(MainActivity.this, "" + selectedItem, Toast.LENGTH_SHORT).show();

    }
}