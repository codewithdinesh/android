package com.exp.radiogrouppractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RadioButton male,female;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked()){
                    Toast.makeText(MainActivity.this, "You clicked male.", Toast.LENGTH_SHORT).show();

            }
                else if(female.isChecked()){
                    Toast.makeText(MainActivity.this, "You clicked female", Toast.LENGTH_SHORT).show();
                }
        }


        });


    }

}