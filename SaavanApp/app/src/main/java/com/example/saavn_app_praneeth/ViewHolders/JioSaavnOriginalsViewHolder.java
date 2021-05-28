package com.example.saavn_app_praneeth.ViewHolders;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.Podcasts.JioSaavnOriginalsModelClass;
import com.example.saavn_app_praneeth.R;

public class JioSaavnOriginalsViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvJioSaavnOriginals;
    public JioSaavnOriginalsViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }
    private void initViews(View itemView) {
        mIvJioSaavnOriginals = itemView.findViewById(R.id.ivjiosaavnoriginalsImages);
    }
    public void setJioSaavnOriginalsData(JioSaavnOriginalsModelClass jioSaavnOriginalsModelClass) {
        mIvJioSaavnOriginals.setImageResource(jioSaavnOriginalsModelClass.getImage());
    }
}
