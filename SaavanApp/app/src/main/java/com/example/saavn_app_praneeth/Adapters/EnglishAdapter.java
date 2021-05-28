package com.example.saavn_app_praneeth.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.R;
import com.example.saavn_app_praneeth.Response.ResultsItem;
import com.example.saavn_app_praneeth.ViewHolders.EnglishViewHolder;

import java.util.List;

public class EnglishAdapter extends RecyclerView.Adapter<EnglishViewHolder> {

    public EnglishAdapter(List<ResultsItem> resultsItemList) {
        this.resultsItemList = resultsItemList;
    }

    private List<ResultsItem> resultsItemList;
    @NonNull
    @Override
    public EnglishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.english_item_layout,parent,false);
        return new EnglishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EnglishViewHolder holder, int position) {
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
