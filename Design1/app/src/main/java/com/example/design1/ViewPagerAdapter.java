package com.example.design1;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {
    int[] imageIDs;

    public ViewPagerAdapter(int[] imageIDs) {
        this.imageIDs = imageIDs;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView vpIm;
        TextView vpTxt;

        public ViewHolder(View itemView) {
            super(itemView);

            vpIm = itemView.findViewById(R.id.vpBookCover);
            vpTxt = itemView.findViewById(R.id.vpTextBox);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pager, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewPagerAdapter.ViewHolder holder, int position) {
        holder.vpIm.setBackgroundResource(imageIDs[position]);
    }

    @Override
    public int getItemCount() {
        return imageIDs.length;
    }
}
