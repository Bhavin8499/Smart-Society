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
import com.sgh000575.smartsociety.admin.AdminDashboardActivity;
import com.sgh000575.smartsociety.model.UserModel;
import com.sgh000575.smartsociety.security.SecurityEntryActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView tvReg;
    Button btnLogin;
    EditText txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SIModel.init(getApplicationContext());

        UserModel model = SIModel.getInstance().isUserAvaliable();
        if(model != null)
            loginUser(model);

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
                                UserModel user = new UserModel(json.getJSONObject("data"));
                                SIModel.getInstance().saveUser(user);
                                UserModel model = SIModel.getInstance().getUser();

                                if(user.role.equalsIgnoreCase("Security")){
                                    SIModel.getInstance().storeFlatDetails(json.getJSONObject("data").getJSONArray("flat_details"));
                                }

                                loginUser(model);
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
    private void loginUser(UserModel user){
        try {
            if(user.getRole().equalsIgnoreCase("Admin")){
                Intent i = new Intent(getApplicationContext(), AdminDashboardActivity.class);
                startActivity( i );
                finish();

            }
            else if(user.getRole().equalsIgnoreCase("Security")) {
                Intent i = new Intent(getApplicationContext(), SecurityEntryActivity.class);
                startActivity( i );
                finish();
            }
            else{
                Intent i = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity( i );
                finish();
            }
        }
        catch (Exception e){

        }
    }


}
