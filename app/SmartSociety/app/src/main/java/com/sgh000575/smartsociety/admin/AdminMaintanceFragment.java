package com.sgh000575.smartsociety.admin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sgh000575.smartsociety.ApiURL;
import com.sgh000575.smartsociety.R;
import com.sgh000575.smartsociety.SIModel;
import com.sgh000575.smartsociety.admin.adapter.AdminCurrentMaintanceAdapter;
import com.sgh000575.smartsociety.model.MaintanceModel;
import com.sgh000575.smartsociety.model.UserModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdminMaintanceFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public AdminMaintanceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    RecyclerView rvMaintance;
    AdminCurrentMaintanceAdapter adapter;
    ArrayList<MaintanceModel> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin_maintance, container, false);
        rvMaintance = view.findViewById(R.id.rvMaintance);

        arrayList = new ArrayList<>();

        adapter = new AdminCurrentMaintanceAdapter(getContext(), arrayList);
        rvMaintance.setAdapter(adapter);



        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        getMaintanceDetails();

    }

    public void  getMaintanceDetails(){

        RequestQueue queue = Volley.newRequestQueue(getContext());

        StringRequest request = new StringRequest(StringRequest.Method.POST, ApiURL.API_GET_ALL_MAINTANCE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject json = new JSONObject(response);
                    JSONArray arr = json.getJSONArray("data");

                    for (int i=0; i<arr.length(); i++){
                        JSONObject obj = arr.getJSONObject(i);

                        MaintanceModel model = new MaintanceModel(obj);
                        arrayList.add(model);
                    }
                    adapter = new AdminCurrentMaintanceAdapter(getContext(), arrayList);
                    rvMaintance.setAdapter(adapter);
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                System.out.println(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                super.getParams();

                HashMap<String, String> map = new HashMap<>();

                UserModel model = SIModel.getInstance().getUser();

                map.put("society_id", model.society_id);

                return map;
            }
        };

        queue.add(request);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
