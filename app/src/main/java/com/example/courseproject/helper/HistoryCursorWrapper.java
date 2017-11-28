package com.example.courseproject.helper;

import android.database.Cursor;
import android.database.CursorWrapper;

import static com.example.courseproject.helper.HistoryDBSchema.HistoryTable.Cols.username;

/**
 * Created by andrew on 11/7/17.
 */

public class HistoryCursorWrapper extends CursorWrapper {
    public HistoryCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public HistoryInfo getInfo(){
        //String username = getString(getColumnIndex(HistoryDBSchema.HistoryTable.Cols.HISID));
        String username = getString(getColumnIndex(HistoryDBSchema.HistoryTable.Cols.username));
        String subject = getString(getColumnIndex(HistoryDBSchema.HistoryTable.Cols.subject));
        int score = getInt(getColumnIndex(HistoryDBSchema.HistoryTable.Cols.score));
        int timecost = getInt(getColumnIndex(HistoryDBSchema.HistoryTable.Cols.timecost));
        //long hisid = getLong(getColumnIndex(HistoryDBSchema.HistoryTable.Cols.HISID));

        HistoryInfo info = new HistoryInfo();
        info.username = username;
        info.subject = subject;
        info.score = score;
        info.timecost = timecost;

        return info;
    }
}
