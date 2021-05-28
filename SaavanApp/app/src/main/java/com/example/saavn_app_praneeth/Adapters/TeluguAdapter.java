package com.example.saavn_app_praneeth.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.R;
import com.example.saavn_app_praneeth.Response.ResultsItem;
import com.example.saavn_app_praneeth.ViewHolders.EnglishViewHolder;
import com.example.saavn_app_praneeth.ViewHolders.TeluguViewHolder;

import java.util.List;

public class TeluguAdapter extends RecyclerView.Adapter<TeluguViewHolder> {
    List<ResultsItem> resultsItemList;
    public TeluguAdapter(List<ResultsItem> resultsItemList) {
        this.resultsItemList=resultsItemList;
    }

    @NonNull
    @Override
    public TeluguViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.telugu_item_layout,parent,false);
        return new TeluguViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeluguViewHolder holder, int position) {
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
