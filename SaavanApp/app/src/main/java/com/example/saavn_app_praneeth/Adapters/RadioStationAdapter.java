package com.example.saavn_app_praneeth.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.R;
import com.example.saavn_app_praneeth.Response.ResultsItem;
import com.example.saavn_app_praneeth.ViewHolders.RadioStationViewHolder;
import com.example.saavn_app_praneeth.ViewHolders.TrendingViewHolder;

import java.util.List;

public class RadioStationAdapter extends RecyclerView.Adapter<RadioStationViewHolder> {

    private List<ResultsItem> resultsItemList;

    public RadioStationAdapter(List<ResultsItem> resultsItemList) {
        this.resultsItemList = resultsItemList;
    }

    @NonNull
    @Override
    public RadioStationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.radiostations_item_layout,parent,false);
        return new RadioStationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RadioStationViewHolder holder, int position) {
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
