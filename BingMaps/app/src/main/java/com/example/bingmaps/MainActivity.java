package com.example.bingmaps;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Intent intentLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMapInit = findViewById(R.id.map_init);
        Button btnCurrentLocation=findViewById(R.id.get_current_location);
        Button btnGetRoute = findViewById(R.id.get_route);

        intentLauncher= new Intent();

        btnMapInit.setOnClickListener(i ->{
            intentLauncher.setClass(this, MapInit.class);
            startActivity(intentLauncher);
        });
        btnCurrentLocation.setOnClickListener(i ->{
            intentLauncher.setClass(this, GetCurrentLocation.class);
            startActivity(intentLauncher);
        });
        btnGetRoute.setOnClickListener(i ->{
            intentLauncher.setClass(this, GetRoute.class);
            startActivity(intentLauncher);
        });


    }
}