package com.example.saavn_app_praneeth.ViewHolders;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.Podcasts.MadeInIndiaModelClass;
import com.example.saavn_app_praneeth.R;

public class MadeInIndiaViewHolder extends RecyclerView.ViewHolder {


    private ImageView mIvArroundTheWorld;

    public MadeInIndiaViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }
    private void initViews(View itemView) {
        mIvArroundTheWorld = itemView.findViewById(R.id.ivMadeInIndiaImages);
    }
    public void setMadeInIndiaData(MadeInIndiaModelClass arroundTheWorldModelClass) {
        mIvArroundTheWorld.setImageResource(arroundTheWorldModelClass.getImage());
    }
}
