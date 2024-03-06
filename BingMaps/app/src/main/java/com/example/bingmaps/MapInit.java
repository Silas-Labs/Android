package com.example.bingmaps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.microsoft.maps.MapRenderMode;
import com.microsoft.maps.MapView;

public class MapInit extends AppCompatActivity {
    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_init);

        FrameLayout frameLayout = findViewById(R.id.map_view);
        mMapView = new MapView(this, MapRenderMode.VECTOR);
        mMapView.setCredentialsKey(getString(R.string.api_key));
        frameLayout.addView(mMapView);
        mMapView.onCreate(savedInstanceState);
    }
}