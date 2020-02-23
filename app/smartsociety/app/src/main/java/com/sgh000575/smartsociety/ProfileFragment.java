package com.sgh000575.smartsociety;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class ProfileFragment extends Fragment {

    RecyclerView member_rv;
    Button add_member;
    ArrayList<String> name ;
    ArrayList<String> gender ;
    ArrayList<String> bithdate;
    ArrayList<String> id;
    ArrayList<String>flat_id;
    ProfileRecyclerViewAdapter prva;

    private OnFragmentInteractionListener mListener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View  view = inflater.inflate( R.layout.fragment_profile, container, false );

        member_rv = view.findViewById(R.id.member_rv);


        member_rv.setLayoutManager( new LinearLayoutManager( getActivity()) );

        //prva =new ProfileRecyclerViewAdapter( getActivity(),name ,gender,bithdate);
        //member_rv.setAdapter( prva );
        add_member = (Button) view.findViewById( R.id.add_member );

        add_member.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( getActivity(),Add_Member.class );
                startActivity( i );
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        name = new ArrayList<String>();
        gender = new ArrayList<String>();
        bithdate = new ArrayList<String>();
        flat_id = new ArrayList<String>();
        id = new ArrayList<String>();
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest( Request.Method.POST, ApiURL.API_GET_ALL_MEMBER, new com.android.volley.Response.Listener<String>() {
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
                                    id.add( innerElem.getString( "id" ) );
                                    name.add( innerElem.getString( "name" ) );
                                    gender.add( innerElem.getString( "gender" ) );
                                    bithdate.add( innerElem.getString( "dob" ) );
                                    flat_id.add( innerElem.getString( "flat_id" ) );
                                }
                            }
                        }
                        prva =new ProfileRecyclerViewAdapter( getActivity(),name ,gender,bithdate,id,flat_id);
                        member_rv.setAdapter( prva );
                    }
                    else{
                        Toast.makeText(getActivity(), "Failed To View Member", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("flat_id", "1");
                return params;
            }
        };
        queue.add(request);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach( context );
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException( context.toString()
                    + " must implement OnFragmentInteractionListener" );
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
