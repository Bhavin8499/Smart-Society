package com.sgh000575.smartsociety.security;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.internal.LinkedTreeMap;
import com.sgh000575.smartsociety.ApiURL;
import com.sgh000575.smartsociety.R;
import com.sgh000575.smartsociety.SIModel;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SecurityEntryActivity extends AppCompatActivity {

    EditText txtName, txtReason;
    AutoCompleteTextView actvFlat;


    ArrayList<String> lstFlatNo, lstFlatNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_entry);
        txtName = findViewById(R.id.txtPersonName);
        txtReason = findViewById(R.id.txtReason);
        actvFlat = findViewById(R.id.txtFlatName);

        lstFlatNames = new ArrayList<>();
        lstFlatNo = new ArrayList<>();

        JSONArray arr = SIModel.getInstance().getFlatDetails();
        try {
            for (int i = 0; i < arr.length(); i++) {
                LinkedTreeMap<String, String> map = ((LinkedTreeMap<String, String>) arr.get(i));

                Object getrow = map.get("nameValuePairs");
                LinkedTreeMap<String,String> t = (LinkedTreeMap) getrow;

                lstFlatNo.add(t.get("flatno"));
                lstFlatNames.add(t.get("flatname")+" - "+t.get("flatno"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1, lstFlatNames);
        actvFlat.setAdapter(adapter);
actvFlat.setThreshold(1);
    }

    public void logoutClicked(View v){
        SIModel.getInstance().logoutUser();
        this.finish();
        Toast.makeText(getApplicationContext(), "Logout Done", Toast.LENGTH_SHORT).show();
    }

    public void addEntry(View v){


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.POST, ApiURL.API_SECUIRY_NEW_MEMBER_COME, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject json = new JSONObject(response);
                    if(json.getBoolean("status")){

                    }
                    else{
                        Toast.makeText(SecurityEntryActivity.this, "Failed To Add Details.", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(SecurityEntryActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("flat_id", lstFlatNo.get(lstFlatNames.indexOf(actvFlat.getText().toString().trim())));
                params.put("name", txtName.getText().toString().trim());
                params.put("reason", txtReason.getText().toString().trim());

                return params;
            }
        };
        queue.add(request);


    }
}
