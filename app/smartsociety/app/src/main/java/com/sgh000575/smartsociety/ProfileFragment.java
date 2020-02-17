package com.sgh000575.smartsociety;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ProfileFragment extends Fragment {

    RecyclerView member_rv;
    Button add_member;

    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view = inflater.inflate( R.layout.fragment_profile, container, false );

        member_rv = (RecyclerView) view.findViewById(R.id.member_rv);

        member_rv.setLayoutManager( new LinearLayoutManager( getActivity()) );
        member_rv.setAdapter( new ProfileRecyclerViewAdapter( getActivity(),new String[]{"Andy Rubin","James Gosling"} ,new String[]{"MALE","MALE"},new String[] {"01-01-1995","01-01-1995"}) );

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
