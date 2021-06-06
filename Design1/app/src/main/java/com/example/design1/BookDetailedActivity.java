package com.example.design1;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;

public class BookDetailedActivity extends AppCompatActivity {
    private ImageView ivBookCover;
    private TextView tvTitle, tvAuthor, tvBlurb, tvCost, tvID;
    private int[] coverImages;
    private ViewPager2 viewPager;
    private ViewPagerAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detailed);
        //ivBookCover = (ImageView) findViewById(R.id.ivBookCover);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvAuthor = (TextView) findViewById(R.id.tvAuthor);
        tvBlurb = (TextView) findViewById(R.id.tvBlurb);
        tvCost = (TextView) findViewById(R.id.tvCost);
        tvID = (TextView) findViewById(R.id.tvID);
        viewPager = (ViewPager2) findViewById(R.id.pager);

        Intent thisIntent = getIntent();
        // Use the book to populate the data into our views
        Books book = (Books) thisIntent.getSerializableExtra(MainActivity.BOOKS_DETAIL_KEY);
        loadBook(book);

        //sets vpAdapter and ensures adjacent pages are rendered for previews
        vpAdapter = new ViewPagerAdapter(coverImages, true, null);
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
        RecyclerView.ItemDecoration buffer = new BookDetailedActivity.HorizMarginBuffer((int) convDpToPx(32f));
        viewPager.addItemDecoration(buffer);
    }
    private void loadBook(Books book) {
        //Loads data from book into relevant fields on the screen
        this.setTitle(book.getTitle());
        tvTitle.setText(book.getTitle());
        tvAuthor.setText(book.getAuthor());
        tvBlurb.setText(book.getBlurb());

        String costText = "Price: $";
        costText = costText.concat(Integer.toString(book.getCost()));
        tvCost.setText(costText);

        String idText = "Book ID: ";
        idText = idText.concat(book.getBookID());
        tvID.setText(idText);
        coverImages = book.getCoverImages();
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
