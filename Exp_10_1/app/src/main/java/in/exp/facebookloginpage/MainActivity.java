package in.exp.facebookloginpage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button loginBtn;
    EditText email_or_phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn = findViewById(R.id.loginBtn);
        email_or_phone = findViewById(R.id.phone_or_email);
        password = findViewById(R.id.password);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email__or__phone = email_or_phone.getText().toString();
                String pass = password.getText().toString();
                if (email__or__phone.equals("abc@email.in") || email__or__phone.equals("9876543210")) {
                    if (pass.equals("@pass123")) {
                        Toast.makeText(MainActivity.this, "login success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "password error", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "login Error ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}