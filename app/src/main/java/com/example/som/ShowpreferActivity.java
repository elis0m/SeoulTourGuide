package com.example.som;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ShowpreferActivity extends AppCompatActivity {

    public static boolean sight, experience, traditional, modern, inside, outside;
    public Button button1, button2, button3, button4, button_all;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showprefer);
        Intent intent = getIntent();
        Log.d("prefer", "" + intent.getExtras().getBoolean("prefer"));

        button1 = (Button) findViewById(R.id.Button_1);
        button2 = (Button) findViewById(R.id.Button_2);
        button3 = (Button) findViewById(R.id.Button_3);
        button4 = (Button) findViewById(R.id.Button_4);
        button_all = (Button) findViewById(R.id.Button_All);


        if (sight) {
            button1.setText("Museum");
            button1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(ShowpreferActivity.this, MuseumActivity.class);
                    startActivity(intent);
                }

            });
        } else if (experience) {
            button1.setText("Korean-style House");
            button1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(ShowpreferActivity.this,HouseActivity.class);
                    startActivity(intent);
                }

            });
        }

        if (traditional) {
            button2.setText("History Museum");
            button2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(ShowpreferActivity.this, HistoryActivity.class);
                    startActivity(intent);
                }

            });
            button3.setText("Cultural Assets");
            /*
            button2.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view){
                    Intent intent = new Intent(ShowpreferActivity.this,HistoryActivity.class);
                    startActivity(intent);
                }

            });
            button3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(ShowpreferActivity.this,AssetActivity.class);
                    startActivity(intent);
                }

            });
             */
        } else if (modern) {
            button2.setText("Art Gallery");
            button2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(ShowpreferActivity.this, GalleryActivity.class);
                    startActivity(intent);
                }

            });
            button3.setText("Opera, Musical, Classical concert");
            button3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(ShowpreferActivity.this, MusicActivity.class);
                    startActivity(intent);
                }

            });
            /*
            button2.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view){
                    Intent intent = new Intent(ShowpreferActivity.this,GalleryActivity.class);
                    startActivity(intent);
                }

            });
            button3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(ShowpreferActivity.this,MusicActivity.class);
                    startActivity(intent);
                }

            });
             */
        }

        if (inside) {
            button4.setText("Play ( in Korean )");
            /*
            button4.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(ShowpreferActivity.this,PlayActivity.class);
                    startActivity(intent);
                }

            });
             */
        } else if (outside) {
            button4.setText("Traditional Market");
            button4.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(ShowpreferActivity.this,MarketActivity.class);
                    startActivity(intent);
                }

            });
        }

        button_all.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ShowpreferActivity.this , MuseumActivity.class);
                startActivity(intent);
            }

        });
    }
}
