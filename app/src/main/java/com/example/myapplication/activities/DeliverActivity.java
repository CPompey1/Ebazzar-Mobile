package com.example.myapplication.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mapbox.geojson.Point;
import com.mapbox.maps.CameraOptions;
import com.mapbox.maps.MapView;

public class DeliverActivity extends AppCompatActivity {
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        mapView = new MapView(this);
        mapView.getMapboxMap().setCamera(
                new CameraOptions.Builder()
                        .center(Point.fromLngLat(-98.0, 39.5))
                        .pitch(0.0)
                        .zoom(2.0)
                        .bearing(0.0)
                        .build()
        );

        setContentView(mapView);

    }
}
