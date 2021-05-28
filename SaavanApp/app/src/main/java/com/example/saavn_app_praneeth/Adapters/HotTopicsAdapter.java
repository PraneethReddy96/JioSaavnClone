package com.example.saavn_app_praneeth.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.Podcasts.HotTopicsModelClass;
import com.example.saavn_app_praneeth.R;
import com.example.saavn_app_praneeth.ViewHolders.HotTopicsViewHolder;

import java.util.List;

public class HotTopicsAdapter extends RecyclerView.Adapter<HotTopicsViewHolder> {
    private List<HotTopicsModelClass> hotTopicsModelClassList;
    public HotTopicsAdapter(List<HotTopicsModelClass> hotTopicsModelClassList) {
        this.hotTopicsModelClassList = hotTopicsModelClassList;
    }
    @NonNull
    @Override
    public HotTopicsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_topics_item_layout,parent,false);
        return new HotTopicsViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull HotTopicsViewHolder holder, int position) {
        HotTopicsModelClass hotTopicsModelClass = hotTopicsModelClassList.get(position);
        holder.setHotTopicsData(hotTopicsModelClass);
    }
    @Override
    public int getItemCount() {
        return hotTopicsModelClassList.size();
    }
}
