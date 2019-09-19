package com.example.foodfactory.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.example.foodfactory.R;
import com.example.foodfactory.adpter.FoodMenuAdapter;
import com.example.foodfactory.all_interface.FoodMenuListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodMenuActivity extends AppCompatActivity {

    ArrayList<String> title = new ArrayList<>();
    FoodMenuAdapter foodMenuAdapter;

    @BindView(R.id.slider)
    SliderLayout slider;
    @BindView(R.id.resturentName)
    TextView resturentName;
    @BindView(R.id.resturentLocation)
    TextView resturentLocation;
    @BindView(R.id.resturentLogo)
    TextView resturentLogo;
    @BindView(R.id.menuItemTxt)
    TextView menuItemTxt;
    @BindView(R.id.reviewTxt)
    TextView reviewTxt;
    @BindView(R.id.foodMenuRecyView)
    RecyclerView foodMenuRecyView;
    @BindView(R.id.floatingActionButton)
    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        ButterKnife.bind(this);

        ButterKnife.bind(this);
        // set slider image
        //inflateImageSlider();


        title.clear();
        for (int i = 0; i < 15; i++) {
            title.add("Spicy Berger" + i);
        }
        foodMenuAdapter = new FoodMenuAdapter(this, title);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(FoodMenuActivity.this, LinearLayoutManager.VERTICAL, false);
        foodMenuRecyView.setLayoutManager(horizontalLayoutManager);
        foodMenuRecyView.setAdapter(foodMenuAdapter);
        foodMenuAdapter.setAdapterListener(new FoodMenuListener() {
            @Override
            public void didPressed(int position) {
                Toast.makeText(FoodMenuActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inflateImageSlider() {


        //populating Image slider
        ArrayList<String> sliderImages = new ArrayList<>();
        sliderImages.add("https://www.printstop.co.in/images/flashgallary/large/Business_stationery_home_banner.jpg");
        sliderImages.add("https://www.printstop.co.in/images/flashgallary/large/calendar-diaries-home-banner.jpg");
        sliderImages.add("https://blackexcellencenetwork.co.za/wp-content/uploads/2018/07/food-wallpapers-photo-For-Desktop-Wallpaper-1.jpg");
        sliderImages.add("https://assets3.thrillist.com/v1/image/2797371/size/tl-horizontal_main_2x.jpg");

        for (String s : sliderImages) {
            DefaultSliderView sliderView = new DefaultSliderView(this);
            sliderView.image(s);
            slider.addSlider(sliderView);
        }

        slider.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);

    }


}
