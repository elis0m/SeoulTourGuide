package com.example.som;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class CategoryFragment extends Fragment {

    Button house, museum, history, music, market, info, asset, gallery, concert, play;
    Button cancel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_category,null);

        house = (Button)view.findViewById(R.id.Button_House);

        //버튼 이벤트
        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                Intent intent = new Intent(getActivity(), HouseActivity.class);
                startActivity(intent);
            }
        });

        museum = (Button)view.findViewById(R.id.Button_Museum);

        //버튼 이벤트
        museum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                Intent intent = new Intent(getActivity(), MuseumActivity.class);
                startActivity(intent);
            }
        });

        history = (Button)view.findViewById(R.id.Button_History);

        //버튼 이벤트
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
            }
        });

        music = (Button)view.findViewById(R.id.Button_Music);

        //버튼 이벤트
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MusicActivity.class);
                startActivity(intent);
            }
        });

        market = (Button)view.findViewById(R.id.Button_Market);

        //버튼 이벤트
        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarketActivity.class);
                startActivity(intent);
            }
        });

        info = (Button)view.findViewById(R.id.Button_Info);

        //버튼 이벤트
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MuseumActivity.class);
                startActivity(intent);
            }
        });

        asset = (Button)view.findViewById(R.id.Button_Asset);

        //버튼 이벤트
        asset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AssetActivity.class);
                startActivity(intent);
            }
        });

        gallery = (Button)view.findViewById(R.id.Button_Gallery);

        //버튼 이벤트
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GalleryActivity.class);
                startActivity(intent);
            }
        });

        concert = (Button)view.findViewById(R.id.Button_Concert);

        //버튼 이벤트
        concert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MusicActivity.class);
                startActivity(intent);
            }
        });

        play = (Button)view.findViewById(R.id.Button_Play);

        //버튼 이벤트
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HouseActivity.class);
                startActivity(intent);
            }
        });

        cancel = (Button)view.findViewById(R.id.Button_Cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MuseumActivity.class);
                startActivity(intent);
            }
        });

        return  view;

    }


    /*
    Button Button_House;
    public MainFragment()
    {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        Button_House = (Button)view.findViewById(R.id.Button_House);

        Button_House.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ((MuseumActivity)getActivity()).onpos
            }
        });
        return view;
    }

    public void changeFragmentTextView(String text)
    {
        tv_fragment.setText(text);
    }

     */
}
