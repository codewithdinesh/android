package in.exp.checkboxes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckBox c, cpp, java, python, c_sharp;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = findViewById(R.id.c);
        cpp = findViewById(R.id.cpp);
        java = findViewById(R.id.java);
        python = findViewById(R.id.python);
        c_sharp = findViewById(R.id.c_sharp);
        submitBtn = findViewById(R.id.submit_btn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBoxes(c, cpp, java, python, c_sharp);
            }
        });

    }

    public void checkBoxes(CheckBox... checkBox) {
        int i;
        String selectedItem = "";

        for (i = 0; i < checkBox.length; i++) {
            if (checkBox[i].isChecked()) {
                selectedItem += checkBox[i].getText().toString()+" ";
            }
        }
        Toast.makeText(MainActivity.this, "" + selectedItem, Toast.LENGTH_SHORT).show();

    }
}