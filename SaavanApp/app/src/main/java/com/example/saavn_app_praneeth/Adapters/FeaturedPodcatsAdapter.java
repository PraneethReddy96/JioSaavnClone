package com.example.saavn_app_praneeth.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.Podcasts.FeaturedPodcatsModelClass;
import com.example.saavn_app_praneeth.R;
import com.example.saavn_app_praneeth.ViewHolders.FeaturedPodcatsViewHolder;

import java.util.List;

public class FeaturedPodcatsAdapter extends RecyclerView.Adapter<FeaturedPodcatsViewHolder> {
    private List<FeaturedPodcatsModelClass> featuredPodcatsModelClassList;
    public FeaturedPodcatsAdapter(List<FeaturedPodcatsModelClass> featuredPodcatsModelClassList) {
        this.featuredPodcatsModelClassList = featuredPodcatsModelClassList;
    }
    @NonNull
    @Override
    public FeaturedPodcatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featuredpodcats_item_layout,parent,false);
        return new FeaturedPodcatsViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull FeaturedPodcatsViewHolder holder, int position) {
        FeaturedPodcatsModelClass featuredPodcatsModelClass = featuredPodcatsModelClassList.get(position);
        holder.setFeaturedPodcatsData(featuredPodcatsModelClass);
    }
    @Override
    public int getItemCount() {
        return featuredPodcatsModelClassList.size();
    }
}
