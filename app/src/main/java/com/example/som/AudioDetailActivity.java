package com.example.som;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AudioDetailActivity extends AppCompatActivity {

    private AudioData audio;
    private TextView TextView_NameENG, TextView_NameKOR, TextView_SimpleENG, TextView_SimpleKOR, TextView_SimpleJAP, TextView_SimpleCHI, TextView_DetailENG, TextView_DetailKOR, TextView_DetailJAP, TextView_DetailCHI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_detail);
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
        TextView_NameENG = findViewById(R.id.TextView_NameENG);
        TextView_NameKOR = findViewById(R.id.TextView_NameKOR);
        TextView_SimpleENG = findViewById(R.id.TextView_SimpleENG);
        TextView_SimpleKOR = findViewById(R.id.TextView_SimpleKOR);
        TextView_SimpleJAP = findViewById(R.id.TextView_SimpleJAP);
        TextView_SimpleCHI = findViewById(R.id.TextView_SimpleCHI);
        TextView_DetailENG = findViewById(R.id.TextView_DetailENG);
        TextView_DetailKOR = findViewById(R.id.TextView_DetailKOR);
        TextView_DetailJAP = findViewById(R.id.TextView_DetailJAP);
        TextView_DetailCHI = findViewById(R.id.TextView_DetailCHI);

    }

    public void setSpot() {
        if (this.audio != null) {
            String a = this.audio.getName_ENG();
            if (a != null) {
                TextView_NameENG.setText(a);
            }
            String b = this.audio.getName_KOR();
            if (b != null) {
                TextView_NameKOR.setText(b);
            }
            String c = this.audio.getSimple_ENG();
            if (c != null) {
                TextView_SimpleENG.setText(c);
            }
            String d = this.audio.getSimple_KOR();
            if (d != null) {
                TextView_SimpleKOR.setText(d);
            }
            String e = this.audio.getSimple_JAP();
            if (e != null) {
                TextView_SimpleJAP.setText(e);
            }
            String f = this.audio.getSimple_CHI();
            if (f != null) {
                TextView_SimpleCHI.setText(f);
            }
            String g = this.audio.getDetail_ENG();
            if (g != null) {
                TextView_DetailENG.setText(g);
            }
            String h = this.audio.getDetail_KOR();
            if (h != null) {
                TextView_DetailKOR.setText(h);
            }
            String i = this.audio.getDetail_JAP();
            if (i != null) {
                TextView_DetailJAP.setText(i);
            }
            String j = this.audio.getDetail_CHI();
            if (j != null) {
                TextView_DetailCHI.setText(j);
            }
        }
    }

    public void getSpotDetail() {
        Intent intent = getIntent();

        if (intent != null) {
            Bundle bld = intent.getExtras();

            Object obj = bld.get("spot");
            if (obj != null && obj instanceof AudioData) {
                this.audio = (AudioData) obj;
            }
        }
    }
}
