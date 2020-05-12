package com.example.som;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MarketDetailActivity extends AppCompatActivity {

    private MarketData market;
    private TextView TextView_Name, TextView_Site, TextView_Address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_detail);
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
        TextView_Site = findViewById(R.id.TextView_Site);
        TextView_Address = findViewById(R.id.TextView_Address);
    }

    public void getSpotDetail() {
        Intent intent = getIntent();

        if (intent != null) {
            Bundle bld = intent.getExtras();

            Object obj = bld.get("market");
            if (obj != null && obj instanceof HouseData) {
                this.market = (MarketData) obj;
            }
        }
    }

    public void setSpot() {
        if (this.market != null) {
            String name = this.market.getName();
            if (name != null) {
                TextView_Name.setText(name);
            }
            String site = this.market.getSite();
            if (site != null) {
                TextView_Site.setText(site);
            }
            String city = this.market.getCity();
            String gu = this.market.getGu();
            String dong = this.market.getDong();
            String address = city + " " + gu + " " + dong;
            if (address != null) {
                TextView_Address.setText(address);
            }
        }
    }
}

