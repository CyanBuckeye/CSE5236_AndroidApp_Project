package com.example.courseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class choosetopic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("choosetopicActivity", "choosetopic_oncreate");
        setContentView(R.layout.activity_choosetopic);
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("choosetopicActivity", "onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d("choosetopicActivity", "onPause");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("choosetopicActivity", "onDestroy");
    }

    protected void onClick_goback(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    protected void onClick_map(View view){
        Intent intent = new Intent(this, mapactivity.class);
        startActivity(intent);
    }
}
