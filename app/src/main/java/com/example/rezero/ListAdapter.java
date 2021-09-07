package com.example.rezero;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<ListV> Ddata;

    public ListAdapter(Context context, ArrayList<ListV> data) {
        mContext = context;
        Ddata = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return Ddata.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public ListV getItem(int position) {
        return Ddata.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.activity_list, null);

        //ImageView imageView = (ImageView)view.findViewById(R.id.poster);
        //imageView.setImageResource(sample.get(position).getPoster());

        TextView designerName = (TextView)view.findViewById(R.id.designerName);
        designerName.setText(Ddata.get(position).getDesignerName());

        TextView designerIntro = (TextView)view.findViewById(R.id.designerIntro);
        designerIntro.setText(Ddata.get(position).getIntroduce());




        return view;
    }
}