package com.example.design1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
public class DetailedPagerAdapter extends RecyclerView.Adapter<DetailedPagerAdapter.DetailedPagerViewHolder> {
    Books testBook = new Books("Test Book Name", "Jenny Smith", 0, 'e', "200", R.drawable.b001);
    protected static class DetailedPagerViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivCover;
        public TextView tvTextBox;
        public DetailedPagerView pagerView;

        public DetailedPagerViewHolder(DetailedPagerView itemView) {
            super(itemView);
            pagerView = itemView;
        }

        public void bindBook(Books book) {
            pagerView.bindBook(book);
        }
    }

    private static final int NUM_PAGES = 5;

    @Override
    public DetailedPagerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) (parent.getContext()).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new DetailedPagerViewHolder(new DetailedPagerView(parent.getContext(), inflater, parent));
    }

    @Override
    public void onBindViewHolder(DetailedPagerViewHolder holder, int position) {
        holder.bindBook(testBook);
    }

    @Override
    public int getItemCount() {
        return DetailedPagerAdapter.NUM_PAGES;
    }
}

