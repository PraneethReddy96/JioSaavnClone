package com.example.saavn_app_praneeth.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.R;
import com.example.saavn_app_praneeth.Response.ResultsItem;
import com.example.saavn_app_praneeth.ViewHolders.SearchActivityViewHolder;
import com.example.saavn_app_praneeth.ViewHolders.SearchFragmentViewHolder;

import java.util.List;

public class SearchFragmentAdapter extends RecyclerView.Adapter<SearchFragmentViewHolder> {
    private List<ResultsItem> resultsItemList;

    public SearchFragmentAdapter(List<ResultsItem> resultsItemList) {
        this.resultsItemList = resultsItemList;
    }

    @NonNull
    @Override
    public SearchFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.search_fragment_item_layout,parent,false);
        return new SearchFragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchFragmentViewHolder holder, int position) {
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
