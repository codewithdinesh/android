package com.studentInfo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentActivity extends AppCompatActivity {
    EditText name, phone_no, branch, roll_no, year, address, age;
    Button submit;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        name = findViewById(R.id.name);
        phone_no = findViewById(R.id.phone_no);
        branch = findViewById(R.id.branch);
        roll_no = findViewById(R.id.roll_no);
        year = findViewById(R.id.year);
        address = findViewById(R.id.Address);
        age = findViewById(R.id.age);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_name, str_phone, str_branch, str_year, str_age, str_address, str_roll_no;

                str_name = name.getText().toString();
                str_phone = phone_no.getText().toString();
                str_year = year.getText().toString();
                str_address = address.getText().toString();
                str_roll_no = roll_no.getText().toString();
                str_branch = branch.getText().toString();
                str_age = age.getText().toString();

                dbHandler.addNewStudent(str_name, str_roll_no, str_year, str_branch, str_age, str_phone, str_address);

                Toast.makeText(StudentActivity.this, "Student Added Successfully \n Roll no" + str_roll_no + "\n Name: " + str_name, Toast.LENGTH_SHORT).show();
            }
        });

    }
}