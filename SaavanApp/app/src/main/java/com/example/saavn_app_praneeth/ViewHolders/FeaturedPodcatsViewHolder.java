package com.example.saavn_app_praneeth.ViewHolders;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.Podcasts.FeaturedPodcatsModelClass;
import com.example.saavn_app_praneeth.R;

public class FeaturedPodcatsViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvFeaturedPodcatsIamges;
    public FeaturedPodcatsViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }
    private void initViews(View itemView) {
        mIvFeaturedPodcatsIamges = itemView.findViewById(R.id.ivFeaturedPodcatsImages);
    }
    public void setFeaturedPodcatsData(FeaturedPodcatsModelClass featuredPodcatsModelClass) {
        mIvFeaturedPodcatsIamges.setImageResource(featuredPodcatsModelClass.getImage());
    }
}
