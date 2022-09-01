package com.exp.loginvalidation;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText password, username;
    Button loginBtn;
    int attempt = 0;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn = findViewById(R.id.loginBtn);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Empty method need
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                showButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Empty method need
            }
        });

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                showButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void showButton() {
        String e = username.getText().toString();
        String pass = password.getText().toString();
        if (!e.isEmpty() && !pass.isEmpty()) {

            if (e.length() > 3 && pass.length() >= 8) {
                loginBtn.setEnabled(true);
                attempt = 0;
            } else {
                Toast.makeText(this, "Unsuccessfully Login Attempt", Toast.LENGTH_SHORT).show();
                loginBtn.setEnabled(false);
                attempt = attempt + 1;
            }
        }
        if (attempt == 3) {
            loginBtn.setEnabled(false);
            Toast.makeText(this, "You have 3 times unsuccessful login attempt", Toast.LENGTH_SHORT).show();
            attempt = 0;
        }
    }

}