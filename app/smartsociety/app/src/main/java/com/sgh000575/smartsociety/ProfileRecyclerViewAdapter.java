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

public class ProfileRecyclerViewAdapter extends RecyclerView.Adapter<ProfileRecyclerViewAdapter.MemberViewHolder> {
    Context context;
    String []name;
    String []gender;
    String []dob;
    LayoutInflater inflater;

    public  ProfileRecyclerViewAdapter(Context context,String []name,String gender[],String dob[]){
        this.context = context;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
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
        holder.member_nm.setText( name[position] );
        holder.profile_ll.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view_profile = new Intent( context,View_Member.class );
                view_profile.putExtra( "mem_name",name[position] );
                view_profile.putExtra( "mem_gen",gender[position] );
                view_profile.putExtra( "mem_dob",dob[position] );
                context.startActivity( view_profile );
            }
        } );
    }
    @Override
    public int getItemCount() {
        return name.length;
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