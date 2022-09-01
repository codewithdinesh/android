package in.exp.exp_9_1;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView blubOn, blubOff;
    ToggleButton switchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blubOn = findViewById(R.id.blubOn);
        blubOff = findViewById(R.id.blubOff);
        switchBtn = findViewById(R.id.switchBtn);

        checkToggle();

        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkToggle();
            }
        });
    }

    public void checkToggle() {
        if (switchBtn.isChecked()) {
            blubOn.setVisibility(View.VISIBLE);
            blubOff.setVisibility(View.GONE);
        } else {
            blubOff.setVisibility(View.VISIBLE);
            blubOn.setVisibility(View.GONE);
        }
    }
}