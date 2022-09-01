package com.studentInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button cancel, login, reset;
    EditText username, password;

    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        cancel = findViewById(R.id.cancel);
        reset = findViewById(R.id.reset);

        dbHandler = new DBHandler(getApplicationContext());

        // add data

        dbHandler.addNewStudent("Dinesh", "123", "2001", "CO", "20", "9876543210", "Alibag");

        Toast.makeText(this, "LIST: " + dbHandler.getStudent("123"), Toast.LENGTH_SHORT).show();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname, pass;
                uname = username.getText().toString();
                pass = password.getText().toString();


                if (uname.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "username can not be empty", Toast.LENGTH_SHORT).show();
                } else if (pass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "password can not be empty", Toast.LENGTH_SHORT).show();
                } else {

                    if ((uname.equals("username") && pass.equals("password"))) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), StudentActivity.class);
                        i.putExtra("username", uname);
                        i.putExtra("password", pass);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                    }

                }
            }


        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setText("");
                password.setText("");
            }
        });
    }
}