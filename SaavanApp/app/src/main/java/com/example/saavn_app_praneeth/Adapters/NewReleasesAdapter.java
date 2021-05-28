package com.example.saavn_app_praneeth.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.R;
import com.example.saavn_app_praneeth.Response.ResultsItem;
import com.example.saavn_app_praneeth.ViewHolders.NewReleasesViewHolder;
import com.example.saavn_app_praneeth.ViewHolders.TrendingViewHolder;

import java.util.List;

public class NewReleasesAdapter extends RecyclerView.Adapter<NewReleasesViewHolder> {

    private List<ResultsItem> resultsItemList;

    public NewReleasesAdapter(List<ResultsItem> resultsItemList) {
        this.resultsItemList = resultsItemList;
    }

    @NonNull
    @Override
    public NewReleasesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.new_releases_item_layout,parent,false);
        return new NewReleasesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewReleasesViewHolder holder, int position) {
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
