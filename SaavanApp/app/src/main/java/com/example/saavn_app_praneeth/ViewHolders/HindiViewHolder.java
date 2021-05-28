package com.example.saavn_app_praneeth.ViewHolders;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.saavn_app_praneeth.MusicActivity;
import com.example.saavn_app_praneeth.MusicPlayer;
import com.example.saavn_app_praneeth.R;
import com.example.saavn_app_praneeth.Response.ResultsItem;

public class HindiViewHolder extends RecyclerView.ViewHolder {

    private ImageView IvSongImage;
    private TextView tvTitle;
    private ConstraintLayout ConstraintContainer;

    public HindiViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        IvSongImage=itemView.findViewById(R.id.ivHindiSongs);
        tvTitle=itemView.findViewById(R.id.tvHindiSongsTitle);
        ConstraintContainer=itemView.findViewById(R.id.hindiSongsContainer);
    }

    public void setData(ResultsItem resultsItem) {
        if(resultsItem.getArtworkUrl100()!=null){
            Glide.with(IvSongImage).load(resultsItem.getArtworkUrl100()).into(IvSongImage);}
        else
        { Glide.with(IvSongImage).load(R.drawable.saavn1).into(IvSongImage);}
        tvTitle.setText(resultsItem.getTrackName());


        ConstraintContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConstraintContainer.getContext(), MusicActivity.class);
                String  Music= resultsItem.getPreviewUrl();
                String  Name=resultsItem.getTrackName();
                String Image=resultsItem.getArtworkUrl100();
                intent.putExtra("Image",Image);
                intent.putExtra("Music",Music);
                intent.putExtra("Name",Name);
                ConstraintContainer.getContext().startActivity(intent);
            }
        });

    }
    }

