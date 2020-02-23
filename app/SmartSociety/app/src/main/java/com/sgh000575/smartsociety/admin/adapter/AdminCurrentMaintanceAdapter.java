package com.sgh000575.smartsociety.admin.adapter;

import com.sgh000575.smartsociety.R;
import com.sgh000575.smartsociety.model.MaintanceModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdminCurrentMaintanceAdapter extends RecyclerView.Adapter<AdminCurrentMaintanceAdapter.ViewHolder> {

    Context context;
    ArrayList<MaintanceModel> maintanceModelArrayList;

    public AdminCurrentMaintanceAdapter(Context context, ArrayList<MaintanceModel> maintanceModelArrayList) {
        this.context = context;
        this.maintanceModelArrayList = maintanceModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.admin_maintance_details, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemView.setTag(maintanceModelArrayList.get(position));

        MaintanceModel dataItem = maintanceModelArrayList.get(position);

        holder.itemView.setTag(dataItem);

        /*String imgSrc = "https://s2.coinmarketcap.com/static/img/coins/64x64/"+dataItem.getId()+".png";

        Picasso.get().load(imgSrc).into(viewHolder.ivCoinImage); //viewHolder.ivCoinImage
        viewHolder.tvName.setText(dataItem.getName());
        viewHolder.tvSymbol.setText(dataItem.getSymbol());
        viewHolder.tvPrice.setText(String.valueOf(dataItem.getQuote().getUSD().getPrice()));
        viewHolder.tvRank.setText(String.valueOf(dataItem.getCmcRank()));
        viewHolder.tvChange24.setText(String.valueOf(dataItem.getQuote().getUSD().getPercentChange24h()));
        */
    }

    @Override
    public int getItemCount() {
        return maintanceModelArrayList.toArray().length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName,  tvPrice, tvDate;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);


            tvName = itemView.findViewById(R.id.maintance_tv_title);
            tvDate = itemView.findViewById(R.id.maintance_tv_date);
            tvPrice = itemView.findViewById(R.id.maintance_tv_amount);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //contextActivity.onItemClicked(coinItems.indexOf((DataItem)itemView.getTag()));
                }
            });

        }
    }

}
