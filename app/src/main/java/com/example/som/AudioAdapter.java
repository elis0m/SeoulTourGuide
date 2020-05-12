package com.example.som;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.CustomViewHolder> {

    private ArrayList<AudioData> mList = null;
    private Activity context = null;
    private View.OnClickListener onClickListener;

    public AudioAdapter(Activity context, ArrayList<AudioData> list, View.OnClickListener onClick) {
        this.context = context;
        this.mList = list;

        onClickListener = onClick;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView name_KOR;
        public TextView name_ENG;

        public View rootView;

        public CustomViewHolder(View view) {
            super(view);
            this.name_KOR = (TextView) view.findViewById(R.id.TextView_NameKOR);
            this.name_ENG = (TextView) view.findViewById(R.id.TextView_NameENG);

            this.rootView = view;

            view.setClickable(true);
            view.setEnabled(true);
            view.setOnClickListener(onClickListener);
        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_audio, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.name_KOR.setText(mList.get(position).getName_KOR());
        viewholder.name_ENG.setText(mList.get(position).getName_ENG());

        viewholder.rootView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

    public AudioData getAudio(int position){

        return mList != null ? mList.get(position) : null;

    }

}