package com.nearInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton open_resto, open_doctors_screen, open_medicals_shops_screen, open_police_Station_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        open_resto = findViewById(R.id.open_resto);
        open_doctors_screen = findViewById(R.id.open_doctors_scree);
        open_medicals_shops_screen = findViewById(R.id.open_medicals_shop_screen);
        open_police_Station_screen = findViewById(R.id.open_police_stations_screen);

        open_resto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(Restaurant.class);
            }
        });

        open_doctors_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(DoctorsScreen.class);
            }
        });

        open_police_Station_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(PoliceStations.class);
            }
        });

        open_medicals_shops_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(PoliceStations.class);
            }
        });
    }

    public void openActivity(Class c) {
        Intent i = new Intent(getApplicationContext(), c);
        startActivity(i);
    }
}