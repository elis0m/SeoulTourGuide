package com.example.som;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView attraction = (ImageView)findViewById(R.id.ImageView_Attraction);
        ImageView wifi = (ImageView)findViewById(R.id.ImageView_Wifi);
        ImageView exchagne = (ImageView)findViewById(R.id.ImageView_Exchange);
        ImageView chat = (ImageView)findViewById(R.id.ImageView_Chat);

        Drawable alphaA = attraction.getDrawable();
        Drawable alphaW = wifi.getDrawable();
        Drawable alphaE = exchagne.getDrawable();
        Drawable alphaC = chat.getDrawable();

        alphaA.setAlpha(99);
        alphaW.setAlpha(80);
        alphaE.setAlpha(99);
        alphaC.setAlpha(80);

        attraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PreferenceActivity.class);
                startActivity(intent);
            }
        });

        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WifiActivity.class);
                startActivity(intent);
            }
        });

        exchagne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ExchangeActivity.class);
                startActivity(intent);
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ChatActivity.class);
                startActivity(intent);
            }
        });
    }
}
