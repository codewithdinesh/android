package in.exp.exp_14_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imgView;
    Button btn;
    static int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView = findViewById(R.id.image);
        btn = findViewById(R.id.changeImgBtn);
        int[] imgList = {R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6};


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i < imgList.length) {
                    imgView.setImageResource(imgList[i]);
                    i++;
                } else {
                    i = 0;
                    imgView.setImageResource(imgList[i]);
                    i++;
                }
            }
        });
    }
}