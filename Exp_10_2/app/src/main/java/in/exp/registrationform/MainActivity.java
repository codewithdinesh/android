package in.exp.registrationform;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button registerBtn;
    EditText email, enrollment_number, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        registerBtn = findViewById(R.id.registerBtn);
        enrollment_number = findViewById(R.id.enrollment_number);
        name = findViewById(R.id.name);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail_address = email.getText().toString();
                String enrollment_no = enrollment_number.getText().toString();
                String nam = name.getText().toString();
                Toast.makeText(MainActivity.this, "Email: " + mail_address + "\nEnrollment number : " + enrollment_no + "\nName : " + nam, Toast.LENGTH_SHORT).show();
            }
        });
    }
}