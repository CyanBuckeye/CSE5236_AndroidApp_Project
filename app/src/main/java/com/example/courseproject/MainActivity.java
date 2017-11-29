package com.example.courseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}

protected void lauchAnotherActivity(View view) {
    Intent intent = new Intent(this, choosetopic.class);
    startActivity(intent);
}


protected void onClick_profile(View view) {
    Intent intent = new Intent(this, historyactivity.class);
    startActivity(intent);
}

protected void onClick_leaderboard(View view){
    Intent intent = new Intent(this, Leaderboard.class);
    startActivity(intent);
}
}
