package com.example.courseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class mapactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapactivity);
    }

    protected void onClick_goback(View view){
        Intent intent = new Intent(this, choosetopic.class);
        startActivity(intent);
    }

    protected void onClick_gofight(View view){
        Intent intent = new Intent(this, fightactivity.class);
        startActivity(intent);
    }


}
