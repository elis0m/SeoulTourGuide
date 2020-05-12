package com.example.som;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SpotActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private SpotData spot;
    private TextView TextView_Name, TextView_Phone, TextView_Site, TextView_Fee1, TextView_Fee2, TextView_Fee3, TextView_latitude, TextView_longitude;
    private Double lat,lon;
    private String name, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot);
        setComp();
        getSpotDetail();
        setSpot();

        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        final Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }

    public void setComp() {
        TextView_Name = findViewById(R.id.TextView_Name);
        TextView_Phone = findViewById(R.id.TextView_Phone);
        TextView_Site = findViewById(R.id.TextView_Site);
        TextView_Fee1 = findViewById(R.id.TextView_Fee1);
        TextView_Fee2 = findViewById(R.id.TextView_Fee2);
        TextView_Fee3 = findViewById(R.id.TextView_Fee3);
        TextView_latitude = findViewById(R.id.TextView_Latitude);
        TextView_longitude = findViewById(R.id.TExtView_Longitude);
    }

    public void getSpotDetail() {
        Intent intent = getIntent();

        if (intent != null) {
            Bundle bld = intent.getExtras();

            Object obj = bld.get("spot");
            if (obj != null && obj instanceof SpotData) {
                this.spot = (SpotData) obj;
            }
        }
    }

    public void setSpot() {
        if (this.spot != null) {
            name = this.spot.getName();
            if (name != null) {
                TextView_Name.setText(name);
            }
            phone = this.spot.getPhone();
            if (phone != null) {
                TextView_Phone.setText(phone);
            }
            String site = this.spot.getSite();
            if (site != null) {
                TextView_Site.setText(site);
            }
            String fee1 = this.spot.getFee1();
            if (fee1 != null) {
                TextView_Fee1.setText(fee1);
            }
            String fee2 = this.spot.getFee2();
            if (fee2 != null) {
                TextView_Fee2.setText(fee2);
            }
            String fee3 = this.spot.getFee3();
            if (fee3 != null) {
                TextView_Fee3.setText(fee3);
            }
            String latitude = this.spot.getLatitude();
            if (latitude != null) {
                lat = Double.parseDouble(latitude);
                TextView_latitude.setText(latitude);
            }
            String longitude = this.spot.getLongitude();
            if (longitude != null) {
                lon = Double.parseDouble(longitude);
                TextView_longitude.setText(longitude);
            }
        }
    }

    @Override
    public void onMapReady(final GoogleMap googleMap){

        mMap = googleMap;

        LatLng SPOT1 = new LatLng(lat,lon);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SPOT1);
        markerOptions.title(name);
        markerOptions.snippet(phone);
        mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(SPOT1));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17));

    }
}
