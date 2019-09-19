package com.example.foodfactory.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodfactory.R;
import com.example.foodfactory.activity.FoodMenuActivity;
import com.example.foodfactory.adpter.FoodMenuAdapter;
import com.example.foodfactory.all_interface.FoodMenuListener;

import java.util.ArrayList;

import butterknife.BindView;


public class ResturentFragment extends Fragment {
    ArrayList<String> title = new ArrayList<>();
    FoodMenuAdapter foodMenuAdapter;
    @BindView(R.id.foodMenuRecyView)
    RecyclerView foodMenuRecyView;
   Context context;

    public ResturentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_resturent, container, false);
        context =getActivity();

        // set adapter
        setAdapter();
       return view;

    }

    private void setAdapter() {
        title.clear();
        for (int i = 0; i < 15; i++) {
            title.add("Spicy Berger" + i);
        }
        foodMenuAdapter = new FoodMenuAdapter(context, title);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        foodMenuRecyView.setLayoutManager(horizontalLayoutManager);
        foodMenuRecyView.setAdapter(foodMenuAdapter);
        foodMenuAdapter.setAdapterListener(new FoodMenuListener() {
            @Override
            public void didPressed(int position) {
                Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
