package in.exp.custom_toast;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.activity_custom_toast,(ViewGroup) findViewById(R.id.container));

//        LinearLayout ll=new LinearLayout(getApplicationContext());
//        ViewGroup.LayoutParams params=ll.getLayoutParams();
//
//        Button btn1=new Button(getApplicationContext());
//        btn1.setText("Yes");
//        ll.addView(btn1);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast toast=new Toast(getApplicationContext());
               toast.setView(layout);
               toast.setDuration(Toast.LENGTH_LONG);
               toast.show();
            }
        });
    }
}