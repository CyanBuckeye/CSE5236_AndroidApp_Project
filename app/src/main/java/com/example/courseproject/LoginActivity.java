package com.example.courseproject;

		
		
		
		import android.content.Intent;
		import android.support.v7.app.AlertDialog;
		import android.support.v7.app.AppCompatActivity;
		import android.os.Bundle;
		import android.view.View;
		import android.widget.Button;
		import android.widget.EditText;
		import android.widget.TextView;
		
		import com.android.volley.RequestQueue;
		import com.android.volley.Response;
		import com.android.volley.toolbox.Volley;
		
		import org.json.JSONException;
		import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_login);
	
	final EditText eusername = (EditText) findViewById(R.id.username);
	final EditText epassword = (EditText) findViewById(R.id.password);
	final Button login = (Button) findViewById(R.id.login);
	final TextView registerLink = (TextView) findViewById(R.id.register);
	
	registerLink.setOnClickListener(new View.OnClickListener(){
		@Override
		public void onClick(View v){
			Intent intent = new Intent(LoginActivity.this, RegistrarActivity.class);
			LoginActivity.this.startActivity(intent);
		}
	});
	
	login.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			final String username = eusername.getText().toString();
			final String password = epassword.getText().toString();
			
			Response.Listener<String> responseL = new Response.Listener<String>() {
				@Override
				public void onResponse(String response) {
					
					try {
						JSONObject json = new JSONObject(response);
						boolean success = json.getBoolean("success");
						
						if(success){
							//String name = json.getString("name");
							Intent intent = new Intent(LoginActivity.this,UserMainFieldActivity.class);
							//intent.putExtra("name", name);//Pass name to the USerAreaActivity
							//intent.putExtra("username", username);
							LoginActivity.this.startActivity(intent);
						}
						else{
							AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
							builder.setMessage("Login Failed")
									.setNegativeButton("Please Retry", null)
									.create()
									.show();
							
						}
					}
					catch(JSONException e){
						e.printStackTrace();
						
					}
					
				}
			};
			
			LoginRequest login = new LoginRequest(username,password,responseL);
			RequestQueue q = Volley.newRequestQueue(LoginActivity.this);
			q.add(login);
		}
	});
}
}

