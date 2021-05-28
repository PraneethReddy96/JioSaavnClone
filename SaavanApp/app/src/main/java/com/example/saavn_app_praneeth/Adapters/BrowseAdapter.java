package com.example.saavn_app_praneeth.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.R;
import com.example.saavn_app_praneeth.Response.ResultsItem;
import com.example.saavn_app_praneeth.ViewHolders.BrowseViewHolder;
import com.example.saavn_app_praneeth.ViewHolders.SearchActivityViewHolder;

import java.util.List;


public class BrowseAdapter extends RecyclerView.Adapter<BrowseViewHolder> {

    private List<ResultsItem> resultsItemList;

    public BrowseAdapter(List<ResultsItem> resultsItemList) {
        this.resultsItemList = resultsItemList;
    }

    @NonNull
    @Override
    public BrowseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.browse_item_layout,parent,false);
        return new BrowseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrowseViewHolder holder, int position) {
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
