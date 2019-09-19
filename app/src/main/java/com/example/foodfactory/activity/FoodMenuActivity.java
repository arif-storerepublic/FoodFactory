package com.example.foodfactory.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.example.foodfactory.R;
import com.example.foodfactory.adpter.FoodMenuAdapter;
import com.example.foodfactory.all_interface.FoodMenuListener;
import com.example.foodfactory.fragment.ResturentFragment;
import com.example.foodfactory.fragment.ResturentReviewFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodMenuActivity extends AppCompatActivity implements View.OnClickListener {


    private ResturentFragment mResturentFragment;
    private ResturentReviewFragment mResturentReviewFragment;

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
    FloatingActionButton floatingActionButton;
    @BindView(R.id.menuHomeFragment)
    FrameLayout menuHomeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        ButterKnife.bind(this);
        initFragment();

        // set slider image
        //inflateImageSlider();

        //set listener
        menuItemTxt.setOnClickListener(this);
        reviewTxt.setOnClickListener(this);
        replaceFragment(mResturentFragment);



    }

    private void initFragment() {
        mResturentFragment = new ResturentFragment();
        mResturentReviewFragment = new ResturentReviewFragment();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.menuItemTxt) {
            replaceFragment(mResturentFragment);
            return;
        }
        if (view.getId() == R.id.reviewTxt) {
            replaceFragment(mResturentReviewFragment);
            return;
        }

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

    //Just replace the one fragment to another fragment
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.menuHomeFragment, fragment);
        fragmentTransaction.commit();

    }
}
