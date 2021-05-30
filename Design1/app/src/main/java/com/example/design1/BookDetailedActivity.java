package com.example.design1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookDetailedActivity extends AppCompatActivity {
    private ImageView ivBookCover;
    private TextView tvTitle;
    private TextView tvAuthor;
    private TextView tvBlurb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detailed);
        ivBookCover = (ImageView) findViewById(R.id.ivBookCover);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvAuthor = (TextView) findViewById(R.id.tvAuthor);
        tvBlurb = (TextView) findViewById(R.id.textViewBlurb);
        Intent thisIntent = getIntent();
        // Use the book to populate the data into our views
        Books book = (Books) thisIntent.getSerializableExtra(MainActivity.BOOKS_DETAIL_KEY);
        loadBook(book);
    }
    private void loadBook(Books book) {
        //change activity title
        this.setTitle(book.getTitle());
        tvTitle.setText(book.getTitle());
        tvAuthor.setText(book.getAuthor());
        //String mDrawableName = book.getCover();
        //int resID = getResources().getIdentifier(mDrawableName ,"drawable", getPackageName());
        int resID = book.getCoverImage();
        ivBookCover.setImageResource(resID);
    }
}
