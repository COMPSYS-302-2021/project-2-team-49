package com.example.design1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.view.Window;


public class MainActivity extends AppCompatActivity {

    public static final String BOOKS_DETAIL_KEY = "books";
    Window thisWindow;
    private ViewPager2 viewPager;
    private ViewPagerAdapter vpAdapter;
    int[] featuredCovers = {R.drawable.e001, R.drawable.l022, R.drawable.m019, R.drawable.m220, R.drawable.e006};
    String[] featuredText = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        thisWindow = getWindow();
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setExitTransition(new Slide());
        getWindow().setEnterTransition(new Slide());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vpAdapter = new ViewPagerAdapter();
    }

    public void onCart(View view){
        Intent cart = new Intent(this, ViewPagerActivity.class);
        startActivity(cart);
    }
    public void onFirst(View view){
        Intent optionFirst = new Intent(this, OptionFirst.class);
        startActivity(optionFirst, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    public void onSecond(View view){
        Intent optionSecond = new Intent(this, OptionSecond.class);
        startActivity(optionSecond, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    public void onThird(View view){
        Intent optionThird = new Intent(this, OptionThird.class);
        startActivity(optionThird, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}