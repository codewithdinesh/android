package in.exp.gridviewexp;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class imageActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = findViewById(R.id.image);

        gridAdapter gridAdapter=new gridAdapter();

        int image_position= getIntent().getIntExtra("image_pos",1);

        imageView.setImageResource(gridAdapter.images[image_position]);
    }
}