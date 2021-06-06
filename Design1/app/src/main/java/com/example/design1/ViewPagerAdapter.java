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
    boolean imageOnly;

    public ViewPagerAdapter(int[] imageIDs, boolean imageOnly) {
        this.imageIDs = imageIDs;
        this.imageOnly = imageOnly;
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
        View view;

        if (!imageOnly) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pager, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pager_2, parent, false);
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewPagerAdapter.ViewHolder holder, int position) {
        holder.vpIm.setBackgroundResource(imageIDs[position]);

        if (!imageOnly) {
            holder.vpTxt.setText("Test Text");
        }
    }

    @Override
    public int getItemCount() {
        return imageIDs.length;
    }
}
