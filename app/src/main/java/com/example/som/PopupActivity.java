package com.example.som;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PopupActivity extends AppCompatActivity {

    Button Button_apply, Button_cancel;
    EditText EditText_nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_popup);

        Button_apply = (Button) findViewById(R.id.Button_apply);
        Button_cancel = (Button) findViewById(R.id.Button_cancel);
        EditText_nickname = findViewById(R.id.EditText_nickname);

    }

    //동작 버튼 클릭
    public void mOk(View v) {
        String newNick = EditText_nickname.getText().toString();

        if(newNick.equals("")){
            Toast.makeText(PopupActivity.this, "Enter a nickname !",Toast.LENGTH_LONG).show();
        }
        else {
            ChatActivity.nick = newNick;
            finish();
        }
    }


    //취소 버튼 클릭
    public void mCancle(View v) {
        finish();
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        //바깥레이어 클릭시 안닫히게
//        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}