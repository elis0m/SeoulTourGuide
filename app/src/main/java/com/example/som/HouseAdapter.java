package com.example.som;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.CustomViewHolder> {

    private ArrayList<HouseData> mList = null;
    private Activity context = null;
    private View.OnClickListener onClickListener;

    public HouseAdapter(Activity context, ArrayList<HouseData> list, View.OnClickListener onClick) {
        this.context = context;
        this.mList = list;

        onClickListener = onClick;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView city;
        public TextView gu;
        public TextView dong;

        public View rootView;

        public CustomViewHolder(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.TextView_Name);
            this.city = (TextView) view.findViewById(R.id.TextView_City);
            this.gu = (TextView) view.findViewById(R.id.TextView_Gu);
            this.dong = (TextView) view.findViewById(R.id.TextView_Dong);

            this.rootView = view;

            view.setClickable(true);
            view.setEnabled(true);
            view.setOnClickListener(onClickListener);
        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_house, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.name.setText(mList.get(position).getName());
        viewholder.city.setText(mList.get(position).getCity());
        viewholder.gu.setText(mList.get(position).getGu());
        viewholder.dong.setText(mList.get(position).getDong());


        viewholder.rootView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

    public HouseData getHouse(int position){

        return mList != null ? mList.get(position) : null;

    }

}