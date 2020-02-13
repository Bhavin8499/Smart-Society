package com.sgh000575.smartsociety;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.MenuViewHolder>
{
    Context context;
    String[] menu;
    int[] menu_img;
    LayoutInflater inflater;

    HomeRecyclerViewAdapter(Context context, String []menu, int []meu_img)
    {
        this.menu =  menu;
        this.menu_img = meu_img;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view =  inflater.inflate( R.layout.home_recycler_layout,viewGroup,false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {

        holder.menu_img.setImageResource(menu_img[position]);
        holder.menu.setText( menu[position] );
    }

    @Override
    public int getItemCount() {
        return menu.length;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView menu_img;
        TextView menu;
        LinearLayout ll;
        public MenuViewHolder(@NonNull View itemView) {
            super( itemView );
            menu = itemView.findViewById(R.id.card_view_image_title);
            menu_img = itemView.findViewById(R.id.card_view_image);
            ll = itemView.findViewById(R.id.home_ll);


        }
    }
}