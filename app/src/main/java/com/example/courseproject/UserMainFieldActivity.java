package com.example.courseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class UserMainFieldActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_main_field);
}

protected void lauchAnotherActivity(View view) {
    Intent intent = new Intent(this, choosetopic.class);
    startActivity(intent);
}


protected void onClick_profile(View view) {
    Intent intent = new Intent(this, Profile.class);
    startActivity(intent);
}

protected void onClick_leaderboard(View view){
    Intent intent = new Intent(this, Leaderboard.class);
    startActivity(intent);
}
}
