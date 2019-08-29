package com.martin.maps;

import android.location.Address;
import android.location.Geocoder;
import android.provider.Telephony;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker marker;
    private EditText addressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        addressEditText = findViewById(R.id.addressEditText);
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

        // Cambiar el tipo de mapa
        mMap.setMapType(googleMap.MAP_TYPE_SATELLITE);

        // Ver el trafico
        mMap.setTrafficEnabled(true);

        // Controles de enfoque
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Agrega un marcador en Barcelona y mueve la cámara
        LatLng barcelona = new LatLng(41.3850639, 2.1734034999999494);
        marker = mMap.addMarker(new MarkerOptions().position(barcelona).title("Es Barcelona"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(barcelona));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(8));

        // Cambiar el sitio
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                marker.setPosition(latLng);
                Geocoder geocoder = new Geocoder(getBaseContext());
                String address = "";
                try {
                    List<Address> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    if(addresses.size() > 0){
                        for(int line = 0; line < addresses.get(0).getMaxAddressLineIndex(); line++){
                            address += addresses.get(0).getAddressLine(line) + "\n";
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                marker.setTitle(address);
            }
        });
    }

    public void findButtonClicked(View view) {
        String address = addressEditText.getText().toString();
        Geocoder geocoder = new Geocoder(this);
        try {
            List<Address> addresses = geocoder.getFromLocationName(address, 1);
            if(addresses.size() > 0){
                LatLng latLng = new LatLng(addresses.get(0).getLatitude(), addresses.get(0).getLongitude());
                marker.setPosition(latLng);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
