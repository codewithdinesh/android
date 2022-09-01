package com.exp.studentregistration;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, clas, phone_no, email, address, roll_no, enroll_no;

    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = findViewById(R.id.register);

        name = findViewById(R.id.name);
        clas = findViewById(R.id.clas);
        phone_no = findViewById(R.id.phone_no);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        roll_no = findViewById(R.id.rollno);
        enroll_no = findViewById(R.id.enrollno);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_name, str_class, str_email, str_address, str_phone_no, str_roll_no, str_enroll_no;

                str_name = name.getText().toString();
                str_class = clas.getText().toString();
                str_email = email.getText().toString();
                str_address = address.getText().toString();
                str_phone_no = phone_no.getText().toString();
                str_roll_no = roll_no.getText().toString();
                str_enroll_no = enroll_no.getText().toString();

                if (str_name.isEmpty() || str_address.isEmpty() || str_class.isEmpty() || str_email.isEmpty() || str_phone_no.isEmpty() || str_roll_no.isEmpty() || str_enroll_no.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Fill all the input.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Student has email " + str_email + " is registered Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}