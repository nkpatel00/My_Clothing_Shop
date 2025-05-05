package com.example.myclothingshop.adepter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myclothingshop.R;
import com.example.myclothingshop.activities.ViewAllActivity;
import com.example.myclothingshop.models.PopularModel;

import java.util.List;


public class PopularAdepter extends RecyclerView.Adapter<PopularAdepter.ViewHolder> {

    private Context context;
    private List<PopularModel>popularModelList;
    public PopularAdepter(Context context,List<PopularModel>popularModelList){
        this.context = context;
        this.popularModelList = popularModelList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(popularModelList.get(position).getImage_url()).into(holder.popImg);
        holder.name.setText(popularModelList.get(position).getName());
        holder.ratting.setText(popularModelList.get(position).getRatting());
        holder.description.setText(popularModelList.get(position).getDescription());
        holder.discount.setText(popularModelList.get(position).getDiscount());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ViewAllActivity.class);
                intent.putExtra("popular_detail", popularModelList.get(position));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return popularModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView popImg;
        TextView name,description,ratting,discount;
        public  ViewHolder(@NonNull View itemView) {
            super(itemView);

            popImg = itemView.findViewById(R.id.pop_image);
            name = itemView.findViewById(R.id.pop_name);
            description = itemView.findViewById(R.id.pop_des);
            discount = itemView.findViewById(R.id.pop_discount);
            ratting = itemView.findViewById(R.id.pop_rating);
        }
    }
}
