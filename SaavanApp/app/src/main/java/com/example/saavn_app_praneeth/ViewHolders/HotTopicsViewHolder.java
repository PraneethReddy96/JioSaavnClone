package com.example.saavn_app_praneeth.ViewHolders;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.Podcasts.HotTopicsModelClass;
import com.example.saavn_app_praneeth.R;

public class HotTopicsViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvHotTopicImage;
    public HotTopicsViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }
    private void initViews(View itemView) {
        mIvHotTopicImage = itemView.findViewById(R.id.ivHotTopicsImages);
    }
    public void setHotTopicsData(HotTopicsModelClass hotTopicsModelClass) {
        mIvHotTopicImage.setImageResource(hotTopicsModelClass.getImage());
    }
}
