package com.sgh000575.smartsociety;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class Add_Member extends AppCompatActivity {

    EditText mem_name;
    RadioGroup mem_gen;
    DatePicker mem_bdate;
    Button add_mem;

    String gender,date;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_member );

        mem_name =  findViewById( R.id.add_mem_name );
        mem_gen = findViewById( R.id.add_mem_gen );
        mem_bdate = findViewById( R.id.add_mem_bdate);
        add_mem = findViewById( R.id.add_mem_btn );

        mem_gen.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.male)
                {gender = "Male";}
                else
                {gender = "Female";}
            }
        } );

        mem_bdate.setOnDateChangedListener( new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date = year+"-"+(monthOfYear+1)+"-"+dayOfMonth;
               // Toast.makeText( getApplicationContext() ,date,Toast.LENGTH_LONG ).show();
            }
        } );

        add_mem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest request = new StringRequest( Request.Method.POST, ApiURL.API_ADD_MEMBER, new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);

                            if(json.getBoolean("status")){
                                    JSONObject data = json.getJSONObject("data");
                                Intent view_profile = new Intent( getApplicationContext(),View_Member.class );
                                    view_profile.putExtra( "mem_name",data.getString( "name" ));
                                    view_profile.putExtra( "mem_gen",data.getString( "gender" ) );
                                    view_profile.putExtra( "mem_dob",data.getString( "dob" ) );
                                    startActivity( view_profile );
                                    finish();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Failed To Add Member", Toast.LENGTH_SHORT).show();
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
                        params.put("name", mem_name.getText().toString());
                        params.put("gender", gender);
                        params.put( "dob",date);
                        params.put( "flat_id",SIModel.getInstance().getUser().flat_id);
                        return params;
                    }
                };
                queue.add(request);
            }
        } );
    }

}
