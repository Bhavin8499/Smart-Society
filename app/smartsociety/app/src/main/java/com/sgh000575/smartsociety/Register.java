package com.sgh000575.smartsociety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {

    LinearLayout subl_soci_code,subl_soci_name;

    EditText fname,lname,soci_name,address,email,pass,phoneno,soci_code;

    Spinner user_type;
    String utype;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.register );

        subl_soci_code = findViewById( R.id.subl_soci_code );
        subl_soci_name = findViewById( R.id.subl_soci_name );
        user_type = findViewById( R.id.user_type );
        fname = findViewById( R.id.et_first_name );
        lname = findViewById( R.id.et_last_name );
        soci_name= findViewById( R.id.et_soci_name );
        soci_code= findViewById( R.id.et_soci_code );
        address= findViewById( R.id.et_soci_addr);
        email = findViewById( R.id.et_email );
        pass= findViewById( R.id.et_password);
        phoneno = findViewById( R.id.et_password);
        register = findViewById( R.id.register_btn);

        user_type.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object obj = parent.getItemAtPosition( position );
                String user_t = String.valueOf( obj);

                if(user_t.equals( "Member" ))
                {
                    utype = "Member";
                    subl_soci_name.setVisibility( View.GONE );
                    subl_soci_code.setVisibility( View.VISIBLE );
                }
                if(user_t.equals( "Admin" ))
                {
                    utype = "Admin";
                    subl_soci_name.setVisibility( View.VISIBLE );
                    subl_soci_code.setVisibility( View.GONE );
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        } );
        register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest request = new StringRequest( Request.Method.POST, ApiURL.API_REGISTER, new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);
                            if(json.getBoolean("status")){
                                Toast.makeText(Register.this, "Welcome", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(),DashboardActivity.class);
                                startActivity( i );
                            }
                            else{
                                Toast.makeText(Register.this, "Failed To login please validate your email and password", Toast.LENGTH_SHORT).show();
                            }
                        }
                        catch (Exception e){
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Register.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("name", fname.getText().toString()+" "+lname.getText().toString());
                        params.put("email", email.getText().toString());
                        params.put( "password",pass.getText().toString() );
                        params.put( "phoneno",phoneno.getText().toString() );
                        params.put( "role",utype);
                        params.put( "socirtycode" , soci_code.getText().toString());
                        params.put( "societyname",soci_name.getText().toString());
                        return params;
                    }
                };
                queue.add(request);

            }
        } );
    }


}
