package com.example.som;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.CustomViewHolder> {

    private ArrayList<SpotData> mList = null;
    private Activity context = null;
    private View.OnClickListener onClickListener;

    public UsersAdapter(Activity context, ArrayList<SpotData> list, View.OnClickListener onClick) {

        this.context = context;
        this.mList = list;

    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView phone;

        public View rootView;

        public CustomViewHolder(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.TextView_Name);
            this.phone = (TextView) view.findViewById(R.id.TextView_Phone);

            this.rootView = view;

            view.setClickable(true);
            view.setEnabled(true);
            view.setOnClickListener(onClickListener);
        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_main, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.name.setText(mList.get(position).getName());
        viewholder.phone.setText(mList.get(position).getPhone());

        viewholder.rootView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

    public SpotData getSpot(int position){

        return mList != null ? mList.get(position) : null;

    }

}
