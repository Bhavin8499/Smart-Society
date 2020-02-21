package com.sgh000575.smartsociety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView tvReg;
    Button btnLogin;
    EditText txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvReg = findViewById( R.id.register_tv );
        btnLogin = findViewById( R.id.login_btn );

        txtEmail = findViewById( R.id.et_login );
        txtPassword = findViewById( R.id.et_password );

        tvReg.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Register.class);
                startActivity( i );
            }
        } );

        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent i = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity( i );*/
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest request = new StringRequest(Request.Method.POST, ApiURL.API_LOGIN, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);
                            if(json.getBoolean("status")){
                                Intent i = new Intent(getApplicationContext(),DashboardActivity.class);
                                startActivity( i );
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Failed To login please validate your email and password", Toast.LENGTH_SHORT).show();
                            }

                            //Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                        }
                        catch (Exception e){

                        }

                        //JsonObject json = new JsonObject(response);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("email", txtEmail.getText().toString());
                        params.put("password", txtPassword.getText().toString());

                        return params;
                    }
                };
                queue.add(request);
            }
        } );
    }
}
