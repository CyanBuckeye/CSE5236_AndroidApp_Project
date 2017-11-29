package com.example.courseproject;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.courseproject.helper.HistoryBaseHelper;
import com.example.courseproject.helper.HistoryCursorWrapper;
import com.example.courseproject.helper.HistoryDBSchema;
import com.example.courseproject.helper.HistoryInfo;
import com.example.courseproject.helper.dataAdaptor;

import java.util.ArrayList;

public class historyactivity extends AppCompatActivity {
    ArrayList<HistoryInfo> arr;
    Context mcontext;
    SQLiteDatabase mDatabase;

    private HistoryCursorWrapper queryHistory(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                HistoryDBSchema.HistoryTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new HistoryCursorWrapper(cursor);
    }

    private ArrayList<HistoryInfo> getAllInfo(){
        ArrayList<HistoryInfo> arr = new ArrayList<HistoryInfo>();
        HistoryCursorWrapper cursor = queryHistory(null, null);

        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                arr.add(cursor.getInfo());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return arr;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historyactivity);

        mcontext = getApplicationContext();
        mDatabase = new HistoryBaseHelper(mcontext).getWritableDatabase();
        arr = getAllInfo();
        /*
        arr = new ArrayList<HistoryInfo>();
        HistoryInfo a = new HistoryInfo("tom", "python", 100, 5);
        HistoryInfo b = new HistoryInfo("jack", "java", 50, 10);
        HistoryInfo c = new HistoryInfo("jerry", "python", 50, 5);
        arr.add(a);
        arr.add(b);
        arr.add(c);
        */
        dataAdaptor adaptor = new dataAdaptor(this, arr);
        ListView v = findViewById(R.id.listv);
        v.setAdapter(adaptor);
    }


    protected void onClick_goback(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
