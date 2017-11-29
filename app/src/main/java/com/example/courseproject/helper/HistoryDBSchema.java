package com.example.courseproject.helper;

/**
 * Created by andrew on 11/7/17.
 */

public class HistoryDBSchema {
    public static final class HistoryTable{
        public static final String NAME = "GameHistory";

        public static final class Cols{
            //public static final String HISID = "hisid";
            public static final String username = "username";
            public static final String subject = "subject";
            public static final String score = "score";
            public static final String timecost = "timecost";
        }
    }
}
