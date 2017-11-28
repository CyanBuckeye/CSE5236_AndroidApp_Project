package com.example.courseproject.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by andrew on 11/7/17.
 */

public class HistoryBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "GameHistory.DB";

    public HistoryBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + HistoryDBSchema.HistoryTable.NAME + "("
         + HistoryDBSchema.HistoryTable.Cols.username + ", "
         + HistoryDBSchema.HistoryTable.Cols.subject + ", "
         + HistoryDBSchema.HistoryTable.Cols.timecost + ", "
         + HistoryDBSchema.HistoryTable.Cols.score + ")");
        Log.d("create db", "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion){

    }
}
