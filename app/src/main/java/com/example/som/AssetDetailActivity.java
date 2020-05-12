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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AssetDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private AssetData asset;
    private TextView TextView_Name, TextView_Phone, TextView_release, TextView_Address, TextView_specified, TextView_latitude, TextView_longitude;
    private Double lat,lon;
    private String name, specified;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_detail);
        setComp();
        getSpotDetail();
        setSpot();

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
        TextView_Address = findViewById(R.id.TextView_Address);
        TextView_specified = findViewById(R.id.TextView_specified);
        TextView_release = findViewById(R.id.TextView_release);
        TextView_latitude = findViewById(R.id.TextView_Latitude);
        TextView_longitude = findViewById(R.id.TextView_Longitude);


    }

    public void getSpotDetail() {
        Intent intent = getIntent();

        if (intent != null) {
            Bundle bld = intent.getExtras();

            Object obj = bld.get("asset");
            if (obj != null && obj instanceof AssetData) {
                this.asset = (AssetData) obj;
            }
        }
    }

    public void setSpot() {
        if (this.asset != null) {
            name = this.asset.getName();
            if (name != null) {
                TextView_Name.setText(name);
            }
            specified = this.asset.getSpecified();
            if (specified != null) {
                TextView_specified.setText(specified);
            }
            String release = this.asset.getRelease();
            if (release != null) {
                TextView_release.setText(release);
            }
            String city = this.asset.getCity();
            String gu = this.asset.getGu();
            String dong = this.asset.getDong();
            String address = city + " " + gu + " " + dong;
            if (address != null) {
                TextView_Address.setText(address);
            }
            String latitude = this.asset.getLatitude();
            if (latitude != null) {
                lat = Double.parseDouble(latitude);
                TextView_latitude.setText(latitude);
            }
            String longitude = this.asset.getLongitude();
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
        markerOptions.snippet(specified);
        mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(SPOT1));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17));

    }
}
