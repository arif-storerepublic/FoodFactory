package com.example.foodfactory.adpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodfactory.R;




public class NearByRestaurantAdapter extends RecyclerView.Adapter<NearByRestaurantAdapter.MyViewHolder> {
    private static final String TAG = "NearByRestaurantAdapter";

    private String [] restaurant_list;
    private Context nearBycontext;

    public NearByRestaurantAdapter(Context nearBycontext, String[] restaurant_list) {

        this.nearBycontext = nearBycontext;
        this.restaurant_list = restaurant_list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d(TAG, "onCreateViewHolder: in onCreateViewHolder");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_restaurant_view,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: in onBindViewHolder");
        holder.restaurantName.setText(restaurant_list[position]);

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: in getItemCount");
        return restaurant_list.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView restaurantName, restaurantMainItemName, restaurantFavorite,
                restaurantRating, restaurantOpenClose;
        ImageView restaurantLogo, restaurantMainItemImage;
        Button menu;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "ViewHolder: in view Holder");
            restaurantName = itemView.findViewById(R.id.restaurant_name_tv);
            restaurantMainItemName = itemView.findViewById(R.id.restaurant_main_item_tv);
            restaurantFavorite = itemView.findViewById(R.id.favorite_tv);
            restaurantRating = itemView.findViewById(R.id.rating_tv);
            restaurantOpenClose = itemView.findViewById(R.id.open_close_tv);

            restaurantLogo = itemView.findViewById(R.id.restaurant_logo_iv);
            restaurantMainItemImage = itemView.findViewById(R.id.restaurant_main_item_iv);

            menu = itemView.findViewById(R.id.restaurant_menu_btn);

        }
    }
}
