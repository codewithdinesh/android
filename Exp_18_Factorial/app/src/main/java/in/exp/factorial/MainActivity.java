package in.exp.factorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText input;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        input = findViewById(R.id.input);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String num = input.getText().toString();
                    int n = Integer.parseInt(num);

                    long fact = 1;
                    for (int i = 1; i < n + 1; i++) {
                        fact = fact * i;
                    }
                    
                    Intent intent = new Intent(getApplicationContext(), outputActivity.class);
                    intent.putExtra("factorial", fact);
                    startActivity(intent);

                } catch (Exception c) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}