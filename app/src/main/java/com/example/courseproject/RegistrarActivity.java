package com.example.courseproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.String;

public class RegistrarActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_registrar);
	
	final EditText ename = (EditText) findViewById(R.id.name);
	final EditText eusername = (EditText) findViewById(R.id.username);
	final EditText epassword = (EditText) findViewById(R.id.password);
	final Button bRegister = (Button) findViewById(R.id.register);
	
	bRegister.setOnClickListener(new View.OnClickListener(){
		@Override
		public void onClick(View v){
			final String name = ename.getText().toString();
			final String username = eusername.getText().toString();
			final String password = epassword.getText().toString();
			
			Response.Listener<String> responseL = new Response.Listener<String>() {
				@Override
				public void onResponse(String response) {
					try {
						JSONObject json = new JSONObject(response);
						boolean success = json.getBoolean("success");
						
						if(success){
							Intent intent = new Intent(RegistrarActivity.this, LoginActivity.class);
							RegistrarActivity.this.startActivity(intent);
						}
						else{
							AlertDialog.Builder builder = new AlertDialog.Builder(RegistrarActivity.this);
							builder.setMessage("Registration Failed")
									.setNegativeButton("Please Retry", null)
									.create()
									.show();
							
						}
					}
					catch (JSONException e){
						e.printStackTrace();
					}
				}
			};
			
			
			RegisterRequest request = new RegisterRequest(name, username, password, responseL);
			
			RequestQueue q = Volley.newRequestQueue(RegistrarActivity.this);
			q.add(request);
		}
	});
}
}

