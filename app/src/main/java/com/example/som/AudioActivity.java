package com.example.som;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class AudioActivity extends AppCompatActivity {

    private static String IP_ADDRESS = "101.101.166.184";
    private static String TAG = "phptest";

    private Button mapButton;

    private EditText mEditTextName;
    private EditText mEditTextPhone;
    private TextView mTextViewResult;
    private ArrayList<AudioData> mArrayList;
    private AudioAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private EditText mEditTextSearchKeyword;
    private String mJsonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        mTextViewResult = (TextView)findViewById(R.id.textView_main_result);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mTextViewResult.setMovementMethod(new ScrollingMovementMethod());

        RecyclerView recyclerView = (RecyclerView)mRecyclerView.findViewById(R.id.my_recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), 1));

        mArrayList = new ArrayList<>();

        mAdapter = new AudioAdapter(this, mArrayList, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Object obj = v.getTag();

                if(obj != null){
                    int position = (int)obj;
                    ((AudioAdapter)mAdapter).getAudio(position).getName_KOR();
                    Intent intent = new Intent(AudioActivity.this , AudioDetailActivity.class);
                    intent.putExtra("spot", ((AudioAdapter)mAdapter).getAudio(position));
                    startActivity(intent);
                }
            }
        });

        mRecyclerView.setAdapter(mAdapter);

        mArrayList.clear();
        mAdapter.notifyDataSetChanged();

        mArrayList.clear();
        mAdapter.notifyDataSetChanged();

        GetData task = new GetData();
        task.execute( "http://101.101.166.184/getjson_audio.php", "");

        //화면 전환 (카테고리)
        final Button categoryButton = (Button) findViewById(R.id.categoryButton);
        final LinearLayout list = (LinearLayout) findViewById(R.id.list);


        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                list.setVisibility(View.GONE);
                categoryButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new CategoryFragment());
                fragmentTransaction.commit();
            }

        });

        //activity 이동
        mapButton = (Button) findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMapActivity();
            }
        });

    }


    public void openMapActivity(){

        Intent intent = new Intent(this,MapActivity.class);
        startActivity(intent);

    }

    private class GetData extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(AudioActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            mTextViewResult.setText(result);
            Log.d(TAG, "response - " + result);

            if (result == null){

                mTextViewResult.setText(errorString);
            }
            else {

                mJsonString = result;
                showResult();
            }
        }


        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];
            String postParameters = params[1];


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "response code - " + responseStatusCode);

                InputStream inputStream;

                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else {
                    inputStream = httpURLConnection.getErrorStream();
                }

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }

                bufferedReader.close();

                return sb.toString().trim();


            } catch (Exception e) {

                Log.d(TAG, "GetData : Error ", e);
                errorString = e.toString();

                return null;
            }

        }
    }



    private void showResult(){

        String TAG_JSON="webnautes";
        String TAG_NAMEe = "name_ENG";
        String TAG_NAMEk ="name_KOR";
        String TAG_SIMPLEk ="simple_KOR";
        String TAG_SIMPLEe ="simple_ENG";
        String TAG_SIMPLEc ="simple_CHI";
        String TAG_SIMPLEj ="simple_JAP";
        String TAG_DETAILk ="detail_KOR";
        String TAG_DETAILe ="detail_ENG";
        String TAG_DETAILc ="detail_CHI";
        String TAG_DETAILj ="detail_JAP";

        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject item = jsonArray.getJSONObject(i);

                String name_ENG = item.getString(TAG_NAMEe);
                String name_KOR = item.getString(TAG_NAMEk);
                String simple_KOR = item.getString(TAG_SIMPLEk);
                String simple_ENG = item.getString(TAG_SIMPLEe);
                String simple_CHI = item.getString(TAG_SIMPLEc);
                String simple_JAP = item.getString(TAG_SIMPLEj);
                String detail_KOR = item.getString(TAG_DETAILk);
                String detail_ENG = item.getString(TAG_DETAILe);
                String detail_CHI = item.getString(TAG_DETAILc);
                String detail_JAP = item.getString(TAG_DETAILj);


                AudioData audioData = new AudioData();

                audioData.setName_ENG(name_ENG);
                audioData.setName_KOR(name_KOR);
                audioData.setSimple_KOR(simple_KOR);
                audioData.setSimple_ENG(simple_ENG);
                audioData.setSimple_CHI(simple_CHI);
                audioData.setSimple_JAP(simple_JAP);
                audioData.setDetail_KOR(detail_KOR);
                audioData.setDetail_ENG(detail_ENG);
                audioData.setDetail_CHI(detail_CHI);
                audioData.setDetail_JAP(detail_JAP);

                mArrayList.add(audioData);
                mAdapter.notifyDataSetChanged();
            }



        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }
    }


}
