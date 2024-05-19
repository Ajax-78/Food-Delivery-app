package com.example.foodorderingapp.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.foodorderingapp.Activity.Domain.FoodDomain;
import com.example.foodorderingapp.R;

import java.util.ArrayList;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder> {


    ArrayList<FoodDomain> items;
    Context context;

    public FoodListAdapter (ArrayList<FoodDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FoodListAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from (parent.getContext ()).inflate (R.layout.viewholder_food_list,parent,false);
        context= parent.getContext ();

        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder (@NonNull  FoodListAdapter.ViewHolder holder, int position){
     holder.timetxt.setText (items.get (position).getTime ()+ "min");
     holder.titletxt.setText (items.get (position).getTitle ());
     holder.scoretxt.setText (""+items.get (position).getScore ());
     int drawableResourceId=holder.itemView.getResources ().getIdentifier (items.get (position).getPicUrl (),"drawable",
             holder.itemView.getContext ().getPackageName ());

        Glide.with (holder.itemView.getContext ()).load (drawableResourceId)
                .transform (new
                        GranularRoundedCorners (30,30,0,0))
                .into (holder.puri);
    }

    @Override
    public int getItemCount () {
        return items.size ();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
 TextView titletxt,timetxt,scoretxt;
 ImageView puri;
         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             titletxt=itemView.findViewById (R.id.titletxt);
             timetxt=itemView.findViewById (R.id.timetxt);
             scoretxt=itemView.findViewById (R.id.scoretxt);
             puri=itemView.findViewById (R.id.puri);
         }
    }
}
