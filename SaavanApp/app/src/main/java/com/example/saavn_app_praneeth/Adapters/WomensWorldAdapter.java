package com.example.saavn_app_praneeth.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.Podcasts.WomenWorldModelClass;
import com.example.saavn_app_praneeth.R;
import com.example.saavn_app_praneeth.ViewHolders.WomensWorldViewHolder;

import java.util.List;

public class WomensWorldAdapter extends RecyclerView.Adapter<WomensWorldViewHolder> {
    private List<WomenWorldModelClass> womenWorldModelClassList;
    public WomensWorldAdapter(List<WomenWorldModelClass> womenWorldModelClassList) {
        this.womenWorldModelClassList = womenWorldModelClassList;
    }
    @NonNull
    @Override
    public WomensWorldViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.womens_world_item_layout,parent,false);
        return new WomensWorldViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull WomensWorldViewHolder holder, int position) {
        WomenWorldModelClass womenWorldModelClass = womenWorldModelClassList.get(position);
        holder.setWomensData(womenWorldModelClass);
    }
    @Override
    public int getItemCount() {
        return womenWorldModelClassList.size();
    }
}
