package com.example.courseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
=======
>>>>>>> refs/remotes/origin/master

public class Profile extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	Log.d("Profile","Profile_onCreate");
	setContentView(R.layout.activity_profile);
<<<<<<< HEAD
	
	this.imageView = (ImageView)this.findViewById(R.id.imageView1);
	Button photoButton = (Button) this.findViewById(R.id.button1);
	
	photoButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(cameraIntent, CAMERA_REQUEST);
		}
	});
}

protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	if (requestCode == CAMERA_REQUEST) {
		Bitmap photo = (Bitmap) data.getExtras().get("data");
		imageView.setImageBitmap(photo);
	}
=======
>>>>>>> refs/remotes/origin/master
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
