package com.example.courseproject;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by kuku on 11/6/17.
 */

public class RegisterRequest extends StringRequest{
	private static final String REGISTER_URL = "https://subclinical-approva.000webhostapp.com/Register.php";
	private Map<String, String> params;
	
	public RegisterRequest(String name, String username, String password, Response.Listener<String> listener){
		super(Method.POST, REGISTER_URL, listener, null);
		params = new HashMap<>();
		params.put("name", name);
		params.put("username", username);
		params.put("password", password);
	}

	@Override
	public Map<String, String> getParams() {
		return params;
	}


}
