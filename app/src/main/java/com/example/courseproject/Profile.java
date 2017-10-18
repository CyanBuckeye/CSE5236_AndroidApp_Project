package com.example.courseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;

public class Profile extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	Log.d("Profile","Profile_onCreate");
	setContentView(R.layout.activity_profile);
}

@Override
public void onResume(){
	super.onResume();
	Log.d("Profile", "onResume");
}

@Override
public void onPause(){
	super.onPause();
	Log.d("Profile", "onPause");
}

@Override
public void onDestroy(){
	super.onDestroy();
	Log.d("Profile", "onDestroy");
}


protected void onClick_goback(View view){
	Intent intent = new Intent(this, MainActivity.class);
	startActivity(intent);
}


}
