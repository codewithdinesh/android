package in.exp.factorial;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class outputActivity extends AppCompatActivity {
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        output = findViewById(R.id.output);
        Intent intent = getIntent();
        Long factorial =  intent.getLongExtra("factorial", 0);
        output.setText("Factorial = " + factorial);
    }
}