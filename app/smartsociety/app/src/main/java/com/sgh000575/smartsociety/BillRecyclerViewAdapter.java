package com.sgh000575.smartsociety;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BillRecyclerViewAdapter extends RecyclerView.Adapter<BillRecyclerViewAdapter.BillViewHolder>  {
    Context context;
    String Title[];
    String Amount[];
    LayoutInflater inflater;

    public BillRecyclerViewAdapter(Context context, String[] title, String[] amount) {
        this.context = context;
        this.Title = title;
        this.Amount = amount;
    }


    @NonNull
    @Override
    public BillViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view =  inflater.inflate( R.layout.profile_recycler_layout,viewGroup,false);
        return new BillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillRecyclerViewAdapter.BillViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BillViewHolder extends RecyclerView.ViewHolder {
        public BillViewHolder(@NonNull View itemView) {
            super( itemView );
        }
    }
}
