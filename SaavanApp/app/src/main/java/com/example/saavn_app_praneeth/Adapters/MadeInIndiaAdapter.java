package com.example.saavn_app_praneeth.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.Podcasts.MadeInIndiaModelClass;
import com.example.saavn_app_praneeth.R;
import com.example.saavn_app_praneeth.ViewHolders.MadeInIndiaViewHolder;

import java.util.List;

public class MadeInIndiaAdapter extends RecyclerView.Adapter<MadeInIndiaViewHolder> {

    private List<MadeInIndiaModelClass> madeInIndiaModelClassList;
    public MadeInIndiaAdapter(List<MadeInIndiaModelClass> madeInIndiaModelClassList) {
        this.madeInIndiaModelClassList = madeInIndiaModelClassList;
    }
    @NonNull
    @Override
    public MadeInIndiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.made_in_india_item_layout,parent,false);
        return new MadeInIndiaViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MadeInIndiaViewHolder holder, int position) {
        MadeInIndiaModelClass madeInIndiaModelClass = madeInIndiaModelClassList.get(position);
        holder.setMadeInIndiaData(madeInIndiaModelClass);
    }
    @Override
    public int getItemCount() {
        return madeInIndiaModelClassList.size();
    }
}
