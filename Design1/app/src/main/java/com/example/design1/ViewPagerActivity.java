package com.example.design1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

public class ViewPagerActivity extends AppCompatActivity {
    ViewPager2 vpHoriz;
    int[] imageIDs = {R.drawable.b001, R.drawable.b001, R.drawable.b001};
    ViewPagerAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_test);

        //Assigns vpHoriz to correct element, sets vpAdapter
        vpHoriz = findViewById(R.id.vpHoriz);
        vpAdapter = new ViewPagerAdapter(imageIDs);
        vpHoriz.setOffscreenPageLimit(1);
        vpHoriz.setAdapter(vpAdapter);

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
        vpHoriz.setPageTransformer(transformer);
        RecyclerView.ItemDecoration buffer = new HorizMarginBuffer((int) convDpToPx(32f));
        vpHoriz.addItemDecoration(buffer);
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