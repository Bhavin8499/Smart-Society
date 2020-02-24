package com.sgh000575.smartsociety;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MaintenenceRecyclerAdapter extends RecyclerView.Adapter<MaintenenceRecyclerAdapter.MaintenenceViewHolder>
{
    Context context;
    ArrayList<String>maintance_name = new ArrayList<>(  );
    ArrayList<String> maintance_date = new ArrayList<>(  );
    ArrayList<String> price = new ArrayList<>(  );
    ArrayList<String> uploader_id =new ArrayList<>(  );

    LayoutInflater inflater;

    public MaintenenceRecyclerAdapter(Context context, ArrayList<String> maintance_name, ArrayList<String> maintance_date, ArrayList<String> price, ArrayList<String> uploader_id) {
        this.context = context;
        this.maintance_name = maintance_name;
        this.maintance_date = maintance_date;
        this.price = price;
        this.uploader_id = uploader_id;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MaintenenceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  inflater.inflate( R.layout.maintenance_recycler_layout,parent,false);
        return new MaintenenceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MaintenenceViewHolder holder, int position) {
            holder.title.setText(maintance_name.get(position));
            holder.date.setText( maintance_date.get( position ) );
            holder.amount.setText( price.get( position ) );
    }

    @Override
    public int getItemCount() {
        return maintance_name.size();
    }

    public class MaintenenceViewHolder extends RecyclerView.ViewHolder {
        TextView title,amount,date;
        public MaintenenceViewHolder(@NonNull View itemView) {
            super( itemView );
            title = itemView.findViewById( R.id.maintenence_tv_title);
            amount =itemView.findViewById( R.id.maintenence_tv_amount );
            date =itemView.findViewById( R.id.maintenence_tv_date );
        }
    }
}
