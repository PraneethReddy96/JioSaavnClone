package com.example.saavn_app_praneeth.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.R;
import com.example.saavn_app_praneeth.Response.ResultsItem;
import com.example.saavn_app_praneeth.ViewHolders.HindiViewHolder;
import com.example.saavn_app_praneeth.ViewHolders.TeluguViewHolder;

import java.util.List;

public class HindiAdapter extends RecyclerView.Adapter<HindiViewHolder> {

    private List<ResultsItem> resultsItemList;
    public HindiAdapter(List<ResultsItem> resultsItemList) {
        this.resultsItemList=resultsItemList;
    }


    @NonNull
    @Override
    public HindiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.hindi_item_layout,parent,false);
        return new HindiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HindiViewHolder holder, int position) {
        ResultsItem resultsItem= resultsItemList.get(position);
        holder.setData(resultsItem);
    }

    @Override
    public int getItemCount() {
        return resultsItemList.size();
    }

    public void updateAdapter(List<ResultsItem> resultsItemList) {
        this.resultsItemList=resultsItemList;
        notifyDataSetChanged();
    }
}
