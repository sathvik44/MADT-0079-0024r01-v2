package com.killer.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(43.7551705,-79.4022384);
        LatLng sydney1 = new LatLng(43.7570981,-79.3983817);
        LatLng sydney2 = new LatLng(43.7604308,-79.3853748);
        LatLng sydney3 = new LatLng(43.7749459,-79.3935983);
        LatLng sydney4 = new LatLng(43.7743492,-79.4173805);
        LatLng sydney5 = new LatLng(43.7624657,-79.4227878);
        LatLng sydney6 = new LatLng(43.7555327,-79.4122558);

        mMap.addMarker(new MarkerOptions().position(sydney).title("Mentor VISHWA"));
        mMap.addMarker(new MarkerOptions().position(sydney1).title("Mentor JAMES"));
        mMap.addMarker(new MarkerOptions().position(sydney2).title("Mentor LUTHOR"));
        mMap.addMarker(new MarkerOptions().position(sydney3).title("Mentor WILLIOMSON"));
        mMap.addMarker(new MarkerOptions().position(sydney4).title("Mentor JACOBS"));
        mMap.addMarker(new MarkerOptions().position(sydney5).title("Mentor DAVID"));
        mMap.addMarker(new MarkerOptions().position(sydney6).title("Mentor KRISTEN"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney1));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney2));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney3));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney4));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney5));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney6));

        mMap.setMinZoomPreference(13.0f);
        mMap.setMaxZoomPreference(44.0f);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String name = marker.getTitle();
                Intent intent = new Intent(MapsActivity.this, Selection.class);
                intent.putExtra("key",name);
                startActivity(intent);
                return false;
            }
        });
        /*mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(MapsActivity.this, Selection.class);

                startActivity(intent);
            }
        });*/
    }


}