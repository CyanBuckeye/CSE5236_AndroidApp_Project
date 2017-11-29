package com.example.courseproject.helper;

/**
 * Created by andrew on 11/5/17.
 */

public class HistoryInfo {
    String username;
    String subject;
    int score;
    int timecost;

    public HistoryInfo(){
        username = "";
        subject = "";
        score = 0;
        timecost = 0;
    }

    public HistoryInfo(String username, String subject, int score, int timecost){
        this.username = username;
        this.subject = subject;
        this.score = score;
        this.timecost = timecost;
    }
}
