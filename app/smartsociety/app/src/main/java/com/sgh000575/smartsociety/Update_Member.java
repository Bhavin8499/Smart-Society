package com.sgh000575.smartsociety;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class Update_Member extends AppCompatActivity {
    TextView member_name;
    RadioButton male,female;
    DatePicker member_dob;
    Button upd_mem;
    String gender,date;
    //String datearr[];
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_update__member);

        member_name = findViewById( R.id.upd_mem_name);
        male = findViewById( R.id.male);
        female = findViewById( R.id.female);
        member_dob = findViewById( R.id.upd_mem_bdate);

        upd_mem = findViewById( R.id.upd_mem_btn );

        final Intent i = getIntent();
        member_name.setText( i.getStringExtra( "mem_name" ).toUpperCase());



        if(i.getStringExtra( "mem_gen" ).equals( "Male" ))
        {gender = "Male";
            male.setChecked(true);
            female.setChecked(false);
        }
        else
        {
            gender = "Female";

            male.setChecked(false);
            female.setChecked(true);
        }
        date =i.getStringExtra( "mem_dob" );
        //datearr = i.getStringExtra( "mem_dob" ).split( "-" );
        //member_dob.init( datearr[0], );

        member_dob.setOnDateChangedListener( new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date = ""+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
                // Toast.makeText( getApplicationContext() ,date,Toast.LENGTH_LONG ).show();
            }
        } );


        upd_mem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest request = new StringRequest( Request.Method.POST, ApiURL.API_UPD_MEMBER, new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);
                            if(json.getBoolean("status")){
                                finish();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Failed To Add Member", Toast.LENGTH_SHORT).show();
                            }
                        }
                        catch (Exception e){
                            Toast.makeText(getApplicationContext(), e.getMessage()+"--", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getLocalizedMessage()+"---", Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("name", member_name.getText().toString());
                        params.put("gender", gender);
                        params.put( "dob",date);
                        params.put( "flat_id",i.getStringExtra( "mem_flat_id" ));
                        params.put( "member_id" ,i.getStringExtra( "mem_id" ));
                        return params;
                    }
                };
                queue.add(request);
            }
        } );


    }
}
