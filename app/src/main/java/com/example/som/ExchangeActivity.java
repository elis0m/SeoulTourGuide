package com.example.som;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ExchangeActivity extends AppCompatActivity {

    String rate="", date = "";  //초기값을 주지않으면 처음 저장된값이 null값이므로 주의
    private String requestUrl;
    String from = "", to = "";

    String input = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        final Spinner spinner_from = findViewById(R.id.Spinner_From);
        final Spinner spinner_to = findViewById(R.id.Spinner_To);
        TextView textView_result = findViewById(R.id.TextView_Result);
        final EditText editText_input = findViewById(R.id.EditText_input);
        Button button_exchange = findViewById(R.id.Button_exchange);

        //textView_result.setPaintFlags(textView_result.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        //스피너에 set 하는 과정
        ArrayAdapter<CharSequence> adapter_from = ArrayAdapter.createFromResource(this, R.array.country_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_to = ArrayAdapter.createFromResource(this, R.array.country_array, android.R.layout.simple_spinner_item);

        adapter_from.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_to.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_from.setAdapter(adapter_from);
        spinner_to.setAdapter(adapter_to);
        spinner_to.setSelection(12);

        //spinner_to.setSelection(2);


        button_exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText_input.getText().toString().equals("")){
                    Toast.makeText(ExchangeActivity.this, "Enter a value !",Toast.LENGTH_LONG).show();
                }
                else {
                    input = editText_input.getText().toString();

                    String[] From = spinner_from.getSelectedItem().toString().split(" ");
                    String[] To = spinner_to.getSelectedItem().toString().split(" ");

                    from = From[0];
                    to = To[0];

                    MyAsyncTask myAsyncTask = new MyAsyncTask();
                    myAsyncTask.execute();
                }
            }
        });

        //https://api.manana.kr/exchange/rate/KRW/JPY.xml

    }


    public class MyAsyncTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {

            requestUrl = "https://api.manana.kr/exchange/rate/"+from+"/"+to+".xml";

            try {
                URL url = new URL(requestUrl);
                InputStream is = url.openStream();
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = factory.newPullParser();
                parser.setInput(new InputStreamReader(is, "UTF-8"));

                String tag;
                int eventType = parser.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    switch (eventType){
                        case XmlPullParser.START_DOCUMENT:
                            //parser가 시작 될때
                            break;
                        case XmlPullParser.START_TAG:
                            tag = parser.getName();
                            if(tag.equals("rate"))
                            {
                                parser.next();
                                rate = parser.getText();
                                Log.v(" rate",parser.getText()); // Value: value
                            }
                            if(tag.equals("date"))
                            {
                                parser.next();
                                date = parser.getText();
                                Log.v(" date",parser.getText()); // Value: value
                            }
                            break;
                        case XmlPullParser.END_DOCUMENT:

                            break;
                        case XmlPullParser.END_TAG:
                            //parser가 끝날때 - ex) </item>

                            break;
                        case XmlPullParser.TEXT:
                            // parser가 내용에 접근했을때

                            break;
                    }
                    eventType = parser.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            TextView textView_date = findViewById(R.id.TextView_Date);
            textView_date.setText("Update date : " + date);

            Double INPUT = Double.parseDouble(input);
            Double RESULT = 0.0;
            Double RATE = Double.parseDouble(rate);

            RESULT = INPUT / RATE;

            String result = String.format("%.2f", RESULT);

            TextView textView_result = findViewById(R.id.TextView_Result);
            textView_result.setText(result);
        }
    }
}