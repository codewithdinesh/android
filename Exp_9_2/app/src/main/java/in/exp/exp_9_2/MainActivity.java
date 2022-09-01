package in.exp.exp_9_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button addBtn, subBtn, multBtn, divBtn;
    EditText num1, num2;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.input_1);
        num2 = findViewById(R.id.input_2);
        addBtn = findViewById(R.id.addNumber);
        subBtn = findViewById(R.id.substractNumber);
        multBtn = findViewById(R.id.multiplyNumber);
        divBtn = findViewById(R.id.divideNumber);
        output = findViewById(R.id.output);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int input_1 = Integer.parseInt(num1.getText().toString());
                    int input_2 = Integer.parseInt(num2.getText().toString());
                    int result = input_1 + input_2;
                    output.setText("Result: " + result);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int input_1 = Integer.parseInt(num1.getText().toString());
                    int input_2 = Integer.parseInt(num2.getText().toString());
                    int result = input_1 - input_2;
                    output.setText("Result: " + result);

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }

            }
        });

        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int input_1 = Integer.parseInt(num1.getText().toString());
                    int input_2 = Integer.parseInt(num2.getText().toString());
                    int result = input_1 * input_2;
                    output.setText("Result: " + result);

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }

            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int input_1 = Integer.parseInt(num1.getText().toString());
                    int input_2 = Integer.parseInt(num2.getText().toString());
                    int result = input_1 / input_2;
                    output.setText("Result: " + result);

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}