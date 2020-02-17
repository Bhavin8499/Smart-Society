package com.sgh000575.smartsociety;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    RecyclerView home_rv;
    TextView society_id;
    String []menu ;
    int []menu_img = {R.drawable.bills,R.drawable.rules,R.drawable.meeting,R.drawable.emergency,R.drawable.contact_us,R.drawable.complain};;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        menu = getResources().getStringArray( R.array.home_fragment_menu );
        home_rv = view.findViewById( R.id.home_rv );
        society_id = view.findViewById( R.id.society_id );

        home_rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        home_rv.setAdapter( new HomeRecyclerViewAdapter(getActivity().getApplicationContext(),menu,menu_img));
        society_id.setText(getAlphaNumericString(6));

        return view;
    }

    public String getAlphaNumericString(int n)
    {
        String Str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Num = "0123456789";
        StringBuilder sb = new StringBuilder(n);
        int index ;
        for (int i = 0; i < n; i++) {
            if(i<=2)
            {
                index = (int)( Str.length() * Math.random());
                sb.append(Str.charAt(index));
            }
            else
            {
                index = (int)( Num.length() * Math.random());
                sb.append(Num.charAt(index));
            }
        }
        return sb.toString();
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
