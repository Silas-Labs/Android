package com.example.bingmaps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.microsoft.maps.AltitudeReferenceSystem;
import com.microsoft.maps.Geopoint;
import com.microsoft.maps.MapAnimationKind;
import com.microsoft.maps.MapElementLayer;
import com.microsoft.maps.MapIcon;
import com.microsoft.maps.MapScene;
import com.microsoft.maps.MapView;

public class GetCurrentLocation extends AppCompatActivity {
    private MapView mapView;
    private double longitude;
    private double latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_current_location);

        mapView = findViewById(R.id.current_location_mapview);
        mapView.setCredentialsKey(getResources().getString(R.string.api_key));
        MapElementLayer elementLayer = new MapElementLayer();
        MapIcon icon = new MapIcon();
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = location -> {
            longitude = location.getLongitude();
            latitude = location.getLatitude();

            icon.setLocation(new Geopoint(latitude, longitude, 0, AltitudeReferenceSystem.SURFACE));
            //----

            // geoposition = new Geoposition(0.202857, 35.096851);

            //====
            elementLayer.getElements().add(icon);
            mapView.getLayers().add(elementLayer);
            mapView.setScene(MapScene.createFromLocation(new Geopoint(latitude, longitude)), MapAnimationKind.LINEAR);

        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        }


        locationManager.requestLocationUpdates(LocationManager.FUSED_PROVIDER, 10000, 10, locationListener);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }
}