package com.example.som;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HouseDetailActivity extends AppCompatActivity {

    private HouseData house;
    private TextView TextView_Name, TextView_Phone, TextView_Site, TextView_Address, TextView_Hours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housedetail);
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
        TextView_Phone = findViewById(R.id.TextView_Phone);
        TextView_Site = findViewById(R.id.TextView_Site);
        TextView_Address = findViewById(R.id.TextView_Address);
        TextView_Hours = findViewById(R.id.TextView_Hours);
    }

    public void getSpotDetail() {
        Intent intent = getIntent();

        if (intent != null) {
            Bundle bld = intent.getExtras();

            Object obj = bld.get("house");
            if (obj != null && obj instanceof HouseData) {
                this.house = (HouseData) obj;
            }
        }
    }

    public void setSpot() {
        if (this.house != null) {
            String name = this.house.getName();
            if (name != null) {
                TextView_Name.setText(name);
            }
            String phone = this.house.getPhone();
            if (phone != null) {
                TextView_Phone.setText(phone);
            }
            String site = this.house.getSite();
            if (site != null) {
                TextView_Site.setText(site);
            }
            String city = this.house.getCity();
            String gu = this.house.getGu();
            String dong = this.house.getDong();
            String address = city + " " + gu + " " + dong;
            if (address != null) {
                TextView_Address.setText(address);
            }
            String hours = this.house.getHours();
            if (hours != null) {
                TextView_Hours.setText(hours);
            }
        }
    }
}
