package com.example.saavn_app_praneeth.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.R;
import com.example.saavn_app_praneeth.Response.ResultsItem;
import com.example.saavn_app_praneeth.ViewHolders.NewReleasesViewHolder;
import com.example.saavn_app_praneeth.ViewHolders.TamilViewHolder;

import java.util.List;

public class TamilAdapter extends RecyclerView.Adapter<TamilViewHolder> {

    private List<ResultsItem> resultsItemList;

    public TamilAdapter(List<ResultsItem> resultsItemList) {
        this.resultsItemList = resultsItemList;
    }

    @NonNull
    @Override
    public TamilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tamil_item_layout,parent,false);
        return new TamilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TamilViewHolder holder, int position) {
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
