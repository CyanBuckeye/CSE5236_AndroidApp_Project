package com.example.courseproject.helper;

/**
 * Created by andrew on 11/5/17.
 */

public class HistoryInfo {
    //public long curr_time;
    public String username;
    public String subject;
    public int score;
    public int timecost;

    public HistoryInfo(){
        username = "";
        subject = "";
        score = 0;
        timecost = 0;
    //    this.curr_time = System.currentTimeMillis();
    }

    /*
    public HistoryInfo(long id){
        curr_time = id;
        username = "";
        subject = "";
        score = 0;
        timecost = 0;
    }
    */

    public HistoryInfo(String username, String subject, int score, int timecost){
        this.username = username;
        this.subject = subject;
        this.score = score;
        this.timecost = timecost;
        //this.curr_time = System.currentTimeMillis();
    }
}
