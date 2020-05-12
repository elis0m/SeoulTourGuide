package com.example.som;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.som.ShowpreferActivity.experience;
import static com.example.som.ShowpreferActivity.inside;
import static com.example.som.ShowpreferActivity.modern;
import static com.example.som.ShowpreferActivity.outside;
import static com.example.som.ShowpreferActivity.sight;
import static com.example.som.ShowpreferActivity.traditional;

public class PreferenceActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    Button submit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        RadioGroup prefer1 = findViewById(R.id.Radio_preference1);
        prefer1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Rbutton_sight:
                        Toast.makeText(getApplicationContext(), "checked Sightseeing", Toast.LENGTH_SHORT).show();
                        sight = true;
                        ShowpreferActivity.experience = false;
                        break;
                    case R.id.Rbutton_experience:
                        Toast.makeText(getApplicationContext(), "checked Experience", Toast.LENGTH_SHORT).show();
                        sight = false;
                        ShowpreferActivity.experience = true;
                        break;
                }
            }
        });

        RadioGroup prefer2 = findViewById(R.id.Radio_preference2);
        prefer2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Rbutton_traditional:
                        Toast.makeText(getApplicationContext(), "checked Traditional", Toast.LENGTH_SHORT).show();
                        ShowpreferActivity.traditional = true;
                        ShowpreferActivity.modern = false;
                        break;
                    case R.id.Rbutton_modern:
                        Toast.makeText(getApplicationContext(), "checked Modern", Toast.LENGTH_SHORT).show();
                        ShowpreferActivity.traditional = false;
                        ShowpreferActivity.modern = true;
                        break;
                }
            }
        });

        RadioGroup prefer3 = findViewById(R.id.Radio_preference3);
        prefer3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Rbutton_inside:
                        Toast.makeText(getApplicationContext(), "checked Inside", Toast.LENGTH_SHORT).show();
                        inside = true;
                        outside = false;
                        break;
                    case R.id.Rbutton_outside:
                        Toast.makeText(getApplicationContext(), "checked Outside", Toast.LENGTH_SHORT).show();
                        inside = false;
                        outside = true;
                        break;
                }
            }
        });



        submit = (Button)findViewById(R.id.Button_preference);

        //버튼 이벤트
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (inside == outside || traditional == modern || sight == experience){

                    Toast.makeText(getApplicationContext(),"Please check your preference !",Toast.LENGTH_SHORT).show();

                }
                else {

                    Intent intent = new Intent(PreferenceActivity.this, ShowpreferActivity.class);
                    intent.putExtra("prefer", sight);
                    intent.putExtra("prefer", experience);
                    intent.putExtra("prefer", modern);
                    intent.putExtra("prefer", traditional);
                    intent.putExtra("prefer", inside);
                    intent.putExtra("prefer", outside);
                    startActivity(intent);
                }
            }
        });

    }
}




        /*radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);



    }

    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            if(i == R.id.Rbutton_sight){
                Toast.makeText(PreferenceActivity.this, "Checked Sightseeing", Toast.LENGTH_SHORT).show();
            }
            else if(i == R.id.Rbutton_experience){
                Toast.makeText(PreferenceActivity.this, "Checked Experience", Toast.LENGTH_SHORT).show();
            }
        }
    };*/

