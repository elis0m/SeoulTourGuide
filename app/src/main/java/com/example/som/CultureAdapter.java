package com.example.som;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CultureAdapter extends RecyclerView.Adapter<CultureAdapter.CustomViewHolder> {

    private ArrayList<CultureData> mList = null;
    private Activity context = null;
    private View.OnClickListener onClickListener;

    public CultureAdapter(Activity context, ArrayList<CultureData> list, View.OnClickListener onClick) {
        this.context = context;
        this.mList = list;

        onClickListener = onClick;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView date;

        public View rootView;

        public CustomViewHolder(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.TextView_Name);
            this.date = (TextView) view.findViewById(R.id.TextView_Date);

            this.rootView = view;

            view.setClickable(true);
            view.setEnabled(true);
            view.setOnClickListener(onClickListener);
        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_culture, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.name.setText(mList.get(position).getName());
        viewholder.date.setText(mList.get(position).getDate());

        viewholder.rootView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

    public CultureData getCulture(int position){

        return mList != null ? mList.get(position) : null;

    }

}