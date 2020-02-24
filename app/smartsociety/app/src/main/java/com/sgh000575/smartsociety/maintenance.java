package com.sgh000575.smartsociety;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class maintenance extends AppCompatActivity {

    RecyclerView maintenence_rv;

    ArrayList<String> maintance_name = new ArrayList<>(  );
    ArrayList<String> maintance_date = new ArrayList<>(  );
    ArrayList<String> price = new ArrayList<>(  );
    ArrayList<String> uploader_id =new ArrayList<>(  );

    MaintenenceRecyclerAdapter mra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_maintenance );

        maintenence_rv =findViewById( R.id.maintenence_rv );

        maintenence_rv.setLayoutManager( new LinearLayoutManager( getApplicationContext()) );

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest( Request.Method.POST, ApiURL.API_GET_MAINTENENCE, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject json = new JSONObject(response);
                    if(json.getBoolean("status")){
                        JSONArray datas = json.getJSONArray("data");
                        if(datas != null) {
                            for (int i = 0; i < datas.length(); i++) {
                                JSONObject innerElem = datas.getJSONObject( i );
                                if (innerElem != null) {
                                    maintance_name.add( innerElem.getString( "maintance_name" ) );
                                    maintance_date.add( innerElem.getString( "maintance_date" ) );
                                    price.add( innerElem.getString( "price" ) );
                                    uploader_id.add( innerElem.getString( "uploader_id" ) );
                                }
                            }
                        }
                        mra =new MaintenenceRecyclerAdapter( getApplicationContext(),maintance_name,maintance_date,price,uploader_id );
                        maintenence_rv.setAdapter( mra );
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Failed To View Maintence", Toast.LENGTH_SHORT).show();
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
                params.put("society_id", "1");
               // params.put( "society_id",SIModel.getInstance().getUser().getSociety_id());
                return params;
            }
        };
        queue.add(request);


    }
}
