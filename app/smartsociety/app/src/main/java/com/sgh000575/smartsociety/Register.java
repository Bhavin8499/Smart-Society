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
import com.sgh000575.smartsociety.admin.AdminDashboardActivity;
import com.sgh000575.smartsociety.model.UserModel;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    LinearLayout subl_soci_code,subl_soci_name,subl_flat_name,subl_flat_no;

    EditText fname,lname,soci_name,address,email,pass,phoneno,soci_code,flat_name,flat_no;

    Spinner user_type;
    String utype;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.register );

        SIModel.init(getApplicationContext());

        subl_soci_code = findViewById( R.id.subl_soci_code );
        subl_soci_name = findViewById( R.id.subl_soci_name );
        subl_flat_name= findViewById( R.id.subl_flat_name);
        subl_flat_no= findViewById( R.id.subl_flat_no);

        user_type = findViewById( R.id.user_type );

        fname = findViewById( R.id.et_first_name );
        lname = findViewById( R.id.et_last_name );

        soci_name= findViewById( R.id.et_soci_name );
        soci_code= findViewById( R.id.et_soci_code );

        email = findViewById( R.id.et_email );

        pass= findViewById( R.id.et_password);
        phoneno = findViewById( R.id.et_mobile);

        register = findViewById( R.id.register_btn);

        flat_name =  findViewById( R.id.et_flat_name);
        flat_no=  findViewById( R.id.et_flat_no);

        user_type.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object obj = parent.getItemAtPosition( position );
                String user_t = String.valueOf( obj);
                if(user_t.equals( "Admin" ))
                {
                    utype = "Admin";
                    subl_soci_name.setVisibility( View.VISIBLE );
                    subl_soci_code.setVisibility( View.GONE );
                    subl_flat_name.setVisibility(  View.GONE );
                    subl_flat_no.setVisibility(  View.GONE );
                }
                if(user_t.equals( "Security" ))
                {
                    utype = "Security";
                    subl_soci_name.setVisibility( View.GONE );
                    subl_soci_code.setVisibility( View.VISIBLE);
                    subl_flat_name.setVisibility(  View.GONE );
                    subl_flat_no.setVisibility(  View.GONE );
                }
                if(user_t.equals( "Member" ))
                {
                    utype = "Member";
                    subl_soci_name.setVisibility( View.GONE );
                    subl_soci_code.setVisibility( View.VISIBLE);
                    subl_flat_name.setVisibility(  View.VISIBLE );
                    subl_flat_no.setVisibility(  View.VISIBLE);
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
                                UserModel user = new UserModel(json.getJSONObject("data"));
                                SIModel.getInstance().saveUser(user);
                                UserModel model = SIModel.getInstance().getUser();
                                loginUser(model);
                            }
                            else{
                                Toast.makeText(Register.this, "Failed To login please Register", Toast.LENGTH_SHORT).show();
                            }
                        }
                        catch (Exception e){
                            Toast.makeText(Register.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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
                        //if(utype.equals( "Admim" )) {
                            params.put( "societyname",soci_name.getText().toString());
                        //}
                        //else if(utype.equals( "Security" )) {
                            params.put( "societycode", soci_code.getText().toString() );
                        //}
                        //else {
                            params.put( "societycode", soci_code.getText().toString());
                            params.put( "flatno", flat_no.getText().toString() );
                            params.put( "flatname", flat_name.getText().toString() );
                        //}
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
                Intent i = new Intent(getApplicationContext(),DashboardActivity.class);
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
