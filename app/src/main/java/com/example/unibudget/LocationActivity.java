package com.example.unibudget;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LocationActivity extends FragmentActivity implements OnMapReadyCallback {
    private BottomNavigationView bottomNavigationView;
    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        SupportMapFragment mapFragment = (SupportMapFragment)  getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment .getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map= googleMap;

        LatLng Florida = new LatLng(27.994402, -81.760254);
        map.addMarker(new MarkerOptions().position(Florida).title("Florida"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Florida));
    }
}