package com.example.courseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.courseproject.helper.HistoryInfo;
import com.example.courseproject.helper.dataAdaptor;

import java.util.ArrayList;

public class historyactivity extends AppCompatActivity {
    ArrayList<HistoryInfo> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historyactivity);
        arr = new ArrayList<HistoryInfo>();
        HistoryInfo a = new HistoryInfo("tom", "python", 100, 5);
        HistoryInfo b = new HistoryInfo("jack", "java", 50, 10);
        HistoryInfo c = new HistoryInfo("jerry", "python", 50, 5);
        arr.add(a);
        arr.add(b);
        arr.add(c);

        dataAdaptor adaptor = new dataAdaptor(this, arr);
        ListView v = findViewById(R.id.listv);
        v.setAdapter(adaptor);
    }


    protected void onClick_goback(View view){
        Intent intent = new Intent(this, UserMainFieldActivity.class);
        startActivity(intent);
    }
}
