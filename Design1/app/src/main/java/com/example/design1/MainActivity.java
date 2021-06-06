package com.example.design1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.transition.Slide;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;


public class MainActivity extends AppCompatActivity {

    public static final String BOOKS_DETAIL_KEY = "books";
    Window thisWindow;
    private ViewPager2 viewPager;
    private ViewPagerAdapter vpAdapter;
    int[] featuredCovers = {R.drawable.e201, R.drawable.e002, R.drawable.e003, R.drawable.e004, R.drawable.e005};
    String[] featuredText = {"Javascript For Kids", "Modern Compiler Design", "Fundamentals of Thermal-Fluid Sciences", "Mechanical Engineering Design", "Electrical Engineering 101"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        thisWindow = getWindow();
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setExitTransition(new Slide());
        getWindow().setEnterTransition(new Slide());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager2) findViewById(R.id.vpFeatured);
        vpAdapter = new ViewPagerAdapter(featuredCovers, false, featuredText);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(vpAdapter);

        //Set values for image margins to make things look nice
        float nextItemDist = convDpToPx(26f);
        float currentItemMargin = convDpToPx(42f);
        float pageTranslation = nextItemDist + currentItemMargin;

        //ViewPager transformer to show 'previews' of next and previous items, also shrinks and fades 'previewed' items
        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                page.setScaleY(0.8f + (1 - Math.abs(position)) * 0.2f);
                page.setAlpha(0.5f + (1 - Math.abs(position)));
                page.setTranslationX((-pageTranslation)*position);
            }
        });

        //set transformer and item decoration
        viewPager.setPageTransformer(transformer);
        RecyclerView.ItemDecoration buffer = new MainActivity.HorizMarginBuffer((int) convDpToPx(32f));
        viewPager.addItemDecoration(buffer);
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
    // Class for adding horizontal margin to ViewPager items, otherwise items overlap visually
    private class HorizMarginBuffer extends RecyclerView.ItemDecoration {
        int marginSize;

        public HorizMarginBuffer(int marginSize) {
            this.marginSize = marginSize;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
            outRect.right = marginSize;
            outRect.left = marginSize;
        }
    }

    //Function for Converting dp to px - Adapted from user 'prasobh' on https://stackoverflow.com/questions/4605527/converting-pixels-to-dp
    private float convDpToPx(float dp){
        Resources r = getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        return px;
    }
}