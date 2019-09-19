package com.example.foodfactory.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodfactory.R;
import com.example.foodfactory.adpter.NearByRestaurantAdapter;



/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView allRestaurantRecyclerView;
    private String [] restaurant_list;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        allRestaurantRecyclerView = view.findViewById(R.id.all_restaurant_rv);
        restaurant_list = getResources().getStringArray(R.array.restaurant_list);
        allRestaurantRecyclerView.setHasFixedSize(true);
        allRestaurantRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        NearByRestaurantAdapter adapter = new NearByRestaurantAdapter(getActivity(),restaurant_list);
        allRestaurantRecyclerView.setAdapter(adapter);
        return view;
    }

}
