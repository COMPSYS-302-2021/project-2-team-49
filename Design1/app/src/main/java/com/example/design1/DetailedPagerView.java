package com.example.design1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailedPagerView extends View {
    public View view;
    ImageView ivBookCover;
    TextView tvTextBox;
    public DetailedPagerView(Context context, LayoutInflater inflater, ViewGroup parent) {
        super(context);
        view = inflater.inflate(R.layout.detailed_pager_layout, parent, false);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ivBookCover = view.findViewById(R.id.ivBookCover);
        tvTextBox = view.findViewById(R.id.textView2);
    }

    public void bindBook(Books book) {
        ivBookCover.setImageResource(book.getCoverImage());
        tvTextBox.setText(book.getTitle());
    }
}
