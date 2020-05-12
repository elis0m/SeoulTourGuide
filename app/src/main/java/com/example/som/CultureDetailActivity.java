package com.example.som;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class CultureDetailActivity extends AppCompatActivity {

    private CultureData culture;
    private TextView TextView_Name, TextView_Date, TextView_Site, TextView_Address, TextView_Target, TextView_Fee, TextView_Cast, TextView_Info, TextView_Etc, TextView_Image;
    private ImageView CultureImage;
    private String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_detail);
        setComp();
        getSpotDetail();
        setSpot();

        CultureImage = findViewById(R.id.CultureImage);

        //url을 image view로 하는 것
        Glide.with(this).load(image).into(CultureImage);

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
        TextView_Date = findViewById(R.id.TextView_Date);
        TextView_Site = findViewById(R.id.TextView_Site);
        TextView_Address = findViewById(R.id.TextView_Address);
        TextView_Target = findViewById(R.id.TextView_Target);
        TextView_Fee = findViewById(R.id.TextView_Fee);
        TextView_Cast = findViewById(R.id.TextView_Cast);
        TextView_Info = findViewById(R.id.TextView_Info);
        TextView_Etc = findViewById(R.id.TextView_Etc);
        TextView_Image = findViewById(R.id.TextView_Image);
    }

    public void getSpotDetail() {
        Intent intent = getIntent();

        if (intent != null) {
            Bundle bld = intent.getExtras();

            Object obj = bld.get("spot");
            if (obj != null && obj instanceof CultureData) {
                this.culture = (CultureData) obj;
            }
        }
    }

    public void setSpot() {
        if (this.culture != null) {
            String name = this.culture.getName();
            if (name != null) {
                TextView_Name.setText(name);
            }
            String date = this.culture.getDate();
            if (date != null) {
                TextView_Date.setText(date);
            }
            String site = this.culture.getWebsite();
            if (site != null) {
                TextView_Site.setText(site);
            }
            String address = this.culture.getAddress();
            if (address != null) {
                TextView_Address.setText(address);
            }
            String target = this.culture.getTarget();
            if (target != null) {
                TextView_Target.setText(target);
            }
            String fee = this.culture.getFee();
            if (fee != null) {
                TextView_Fee.setText(fee);
            }
            String cast = this.culture.getCast();
            if (cast != null) {
                TextView_Cast.setText(cast);
            }
            String information = this.culture.getInformation();
            if (information != null) {
                TextView_Info.setText(information);
            }
            String etc = this.culture.getEtc();
            if (etc != null) {
                TextView_Etc.setText(etc);
            }
            image = this.culture.getImage();
            if (image != null) {
                TextView_Image.setText(image);
            }
        }
    }
}
