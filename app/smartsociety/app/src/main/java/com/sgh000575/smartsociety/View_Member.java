package com.sgh000575.smartsociety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class View_Member extends AppCompatActivity {

    TextView member_name,member_gender,member_dob;
    Button delete_mem,upd_mem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_view__member );

        member_name = findViewById( R.id.view_pro_name );
        member_gender = findViewById( R.id.view_profile_gen );
        member_dob = findViewById( R.id.view_profile_bdate );

        delete_mem = findViewById( R.id.delet_mem_btn );
        upd_mem = findViewById( R.id.upd_mem_btn );

        final Intent i = getIntent();

        member_name.setText( i.getStringExtra( "mem_name" ).toUpperCase());
        member_gender.setText( i.getStringExtra( "mem_gen" ).toUpperCase());
        member_dob.setText( i.getStringExtra( "mem_dob" ));



        delete_mem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest request = new StringRequest( Request.Method.POST, ApiURL.API_DEL_MEMBER, new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);

                            if(json.getBoolean("status")){
                                finish();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Failed To Delete Member", Toast.LENGTH_SHORT).show();
                            }
                        }
                        catch (Exception e){
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("member_id",i.getStringExtra( "mem_id" ));
                        return params;
                    }
                };
                queue.add(request);
            }
        } );


        upd_mem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent upd_profile = new Intent( getApplicationContext(),Update_Member.class );
                upd_profile.putExtra( "mem_name",i.getStringExtra( "mem_name" ));
                upd_profile.putExtra( "mem_id",i.getStringExtra( "mem_id" ) );
                upd_profile.putExtra( "mem_flat_id",i.getStringExtra( "mem_flat_id" ));
                upd_profile.putExtra( "mem_gen",i.getStringExtra( "mem_gen" ));
                upd_profile.putExtra( "mem_dob",i.getStringExtra( "mem_dob" ));
                startActivity( upd_profile);
                finish();
            }
        } );

    }
}

