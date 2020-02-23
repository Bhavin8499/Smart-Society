package com.sgh000575.smartsociety;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProfileRecyclerViewAdapter extends RecyclerView.Adapter<ProfileRecyclerViewAdapter.MemberViewHolder> {
    Context context;
    ArrayList<String> name = new ArrayList<String >();
    ArrayList<String> gender = new ArrayList<String >();
    ArrayList<String> dob = new ArrayList<String >();
    ArrayList<String> flat_id = new ArrayList<String >();
    ArrayList<String> id = new ArrayList<String >();

    LayoutInflater inflater;

    public  ProfileRecyclerViewAdapter(Context context,ArrayList<String> name,ArrayList<String> gender,ArrayList<String> dob,ArrayList<String> id,ArrayList<String> flat_id){
        this.context = context;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.id=id;
        this.flat_id =flat_id;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view =  inflater.inflate( R.layout.profile_recycler_layout,viewGroup,false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, final int position) {
        holder.member_nm.setText( name.get( position ).toUpperCase() );
        holder.profile_ll.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view_profile = new Intent( context,View_Member.class );
                view_profile.putExtra( "mem_name",name.get( position ) );
                view_profile.putExtra( "mem_id",id.get( position ) );
                view_profile.putExtra( "mem_flat_id",flat_id.get( position ) );
                view_profile.putExtra( "mem_gen",gender.get( position ) );
                view_profile.putExtra( "mem_dob",dob.get( position ) );
                context.startActivity( view_profile );
            }
        } );
    }
    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder
    {
        TextView member_nm;
        LinearLayout profile_ll;
        public MemberViewHolder(@NonNull View itemView)
        {
            super( itemView );
            member_nm =  itemView.findViewById( R.id.member_nm );
            profile_ll = itemView.findViewById( R.id.profile_ll);
        }
    }
}