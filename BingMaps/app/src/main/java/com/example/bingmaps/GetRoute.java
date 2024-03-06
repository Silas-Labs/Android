package com.example.bingmaps;

import static com.example.bingmaps.APIResponse.mapResponse;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.JsonReader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.microsoft.maps.AltitudeReferenceSystem;
import com.microsoft.maps.Geopath;
import com.microsoft.maps.Geopoint;
import com.microsoft.maps.Geoposition;
import com.microsoft.maps.MapAnimationKind;
import com.microsoft.maps.MapElementLayer;
import com.microsoft.maps.MapIcon;
import com.microsoft.maps.MapPolyline;
import com.microsoft.maps.MapScene;
import com.microsoft.maps.MapView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class GetRoute extends AppCompatActivity {
    private MapView mapView;
    private double longitude; //35.130983
    private double latitude; //0.197388
    private final double destLong = 35.096851;
    private final double destLat = 0.202857;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_route);

        mapView = findViewById(R.id.get_route_map);
        mapView.setCredentialsKey(getResources().getString(R.string.api_key));

        MapIcon icon = new MapIcon();
        MapElementLayer elementLayer = new MapElementLayer();

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = location -> {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            icon.setLocation(new Geopoint(latitude, longitude, 0, AltitudeReferenceSystem.SURFACE));
            elementLayer.getElements().add(icon);
            mapView.getLayers().add(elementLayer);
            mapView.setScene(MapScene.createFromLocation(new Geopoint(latitude, longitude)), MapAnimationKind.LINEAR);
        };
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        } else {
            locationManager.requestLocationUpdates(LocationManager.FUSED_PROVIDER, 1000000, 1, locationListener);

        }

        List<Geoposition> routeCoordinates= new ArrayList<>();
        try{
            JSONObject jsonResponse = new JSONObject(mapResponse);
            JSONArray resourceSets= jsonResponse.getJSONArray("resourceSets");
            JSONObject resourceSet=resourceSets.getJSONObject(0);
            JSONArray resources= resourceSet.getJSONArray("resources");
            JSONObject routeJson= resources.getJSONObject(0);
            //JSONArray routeGeometry = routeJson.getJSONObject("routePath")
              //      .getJSONObject("line").getJSONArray("coordinates");

            if(routeJson.has("routeLegs")){
                JSONArray routeLegs= routeJson.getJSONArray("routeLegs");

                for(int i =0;i<routeLegs.length();i++){
                    JSONObject routeLeg =routeLegs.getJSONObject(i);
                   // JSONObject actualStart = routeLeg.getJSONObject("actualStart");
                    //JSONArray startCoordinates = actualStart.getJSONArray("coordinates");
                    JSONArray routePath = routeLeg.getJSONArray("routeSubLegs");
                    for(int j=0;j<routePath.length();j++) {
                        JSONArray coordinates =routePath.getJSONArray(j);
                        double startLat = coordinates.getDouble(0);
                        double startLon = coordinates.getDouble(1);
                        routeCoordinates.add(new Geoposition(startLat, startLon));
                    }
//                    JSONObject actualEnd = routeLeg.getJSONObject("actualEnd");
//                    JSONArray endCoordinates = actualEnd.getJSONArray("coordinates");
//                    double endLatitude = endCoordinates.getDouble(0);
//                    double endLongitude = endCoordinates.getDouble(1);
//                    routeCoordinates.add(new Geoposition(endLatitude,endLongitude));

                }
            }
           /* for(int i=0;i<routeGeometry.length();i++){
                JSONArray point= routeGeometry.getJSONArray(i);
                double latitude = point.getDouble(0);
                double longitude = point.getDouble(1);
                routeCoordinates.add(new Geoposition(latitude,longitude));*/
//                JSONObject routeLeg= routeLegs.getJSONObject(i);
//                JSONArray itineraryItems = routeLeg.getJSONArray("itineraryItems");
//
//                for(int j=0;j<itineraryItems.length();j++){
//                    JSONObject itineraryItem= itineraryItems.getJSONObject(j);
//                    JSONArray coordinates= itineraryItem.getJSONObject("maneuverPoint").getJSONArray("coordinates");
//                    double latitude = coordinates.getDouble(0);
//                    double longitude = coordinates.getDouble(1);
//                    routeCoordinates.add(new Geoposition(latitude,longitude));
//                }
            //}
        }catch(Exception e){
            System.out.println("Error opening file");
            System.out.println(e);

        }
        MapPolyline polyline= new MapPolyline();
        Geopath path = new Geopath(routeCoordinates);
        polyline.setPath(path);
        polyline.setStrokeColor(Color.BLUE);
        polyline.setStrokeWidth(4);
        elementLayer.getElements().add(polyline);
        mapView.getLayers().add(elementLayer);

    }
}