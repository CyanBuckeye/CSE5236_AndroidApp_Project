package com.example.courseproject.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.courseproject.R;

import java.util.ArrayList;

/**
 * Created by andrew on 11/6/17.
 */

public class dataAdaptor extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<HistoryInfo> mDatasource;

    public dataAdaptor(Context context, ArrayList<HistoryInfo> mDatasource){
        this.mContext = context;
        this.mDatasource = mDatasource;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return mDatasource.size();
    }

    @Override
    public Object getItem(int position){
        return mDatasource.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View covertView, ViewGroup parent){
        View rowView = mInflater.inflate(R.layout.itemview, parent, false);
        TextView userView = rowView.findViewById(R.id.username);
        TextView subjectView = rowView.findViewById(R.id.subject);
        TextView scoreView = rowView.findViewById(R.id.history_score);
        TextView timeView = rowView.findViewById(R.id.history_time);
        HistoryInfo info = (HistoryInfo)getItem(position);
        userView.setText(info.username);
        subjectView.setText(info.subject);
        scoreView.setText(Integer.toString(info.score));
        timeView.setText(Integer.toString(info.timecost));
        return rowView;
    }
}
