package com.example.saavn_app_praneeth.ViewHolders;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.Podcasts.WomenWorldModelClass;
import com.example.saavn_app_praneeth.R;

public class WomensWorldViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvWoemensWorldImages;

    public WomensWorldViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvWoemensWorldImages = itemView.findViewById(R.id.ivWomensWorldImages);
    }

    public void setWomensData(WomenWorldModelClass womenWorldModelClass) {
        mIvWoemensWorldImages.setImageResource(womenWorldModelClass.getImage());
    }
}
