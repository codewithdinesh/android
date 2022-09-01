package in.exp.order_food;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckBox pizza, burger, coffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pizza = findViewById(R.id.pizza);
        burger = findViewById(R.id.burger);
        coffee = findViewById(R.id.coffee);
        Button order = findViewById(R.id.order_btn);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBoxes(pizza, burger, coffee);
            }
        });
    }

    public void checkBoxes(CheckBox... checkBox) {
        int i;
        String selectedItem = "Selected Items:\n";
        int[] price = {250, 120, 60};
        int total = 0;
        for (i = 0; i < checkBox.length; i++) {
            if (checkBox[i].isChecked()) {
                selectedItem += checkBox[i].getText().toString() + "- " + price[i] + "\n";
                total += price[i];
            }
        }
        Toast.makeText(MainActivity.this, "" + selectedItem + "Total: " + total, Toast.LENGTH_SHORT).show();

    }
}