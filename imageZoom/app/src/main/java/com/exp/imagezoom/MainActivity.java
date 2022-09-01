package com.exp.imagezoom;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomControls;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    ZoomControls zoomControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        zoomControls = findViewById(R.id.zoomc);

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                zoomControls.show();
                return false;
            }
        });

        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = img.getScaleX();
                float y = img.getScaleY();

                img.setScaleX(x + 0.5f);
                img.setScaleY(y + 0.5f);

                zoomControls.hide();
            }
        });

        zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = img.getScaleX();
                float y = img.getScaleY();
                if (x == 1 && y == 1) {
                    img.setScaleX(x);
                    img.setScaleY(y);
                    zoomControls.hide();
                } else {

                    img.setScaleX(x - 0.5f);
                    img.setScaleY(y - 0.5f);
                    zoomControls.hide();

                }
            }
        });
    }
}