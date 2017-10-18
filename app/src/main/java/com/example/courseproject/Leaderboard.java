package com.example.courseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

public class Leaderboard extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	Log.d("Leaderboard", "Leaderboard_onCreate");
	setContentView(R.layout.activity_leaderboard);
}

@Override
public void onResume(){
	super.onResume();
	Log.d("Leaderboard", "onResume");
}

@Override
public void onPause(){
	super.onPause();
	Log.d("Leaderboard", "onPause");
}

@Override
public void onDestroy(){
	super.onDestroy();
	Log.d("Leaderboard", "onDestroy");
}

protected void onClick_goback(View view){
	Intent intent = new Intent(this, MainActivity.class);
	startActivity(intent);
}
}
