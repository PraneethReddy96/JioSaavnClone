package com.example.saavn_app_praneeth.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavn_app_praneeth.Podcasts.JioSaavnOriginalsModelClass;
import com.example.saavn_app_praneeth.R;
import com.example.saavn_app_praneeth.ViewHolders.JioSaavnOriginalsViewHolder;

import java.util.List;

public class JioSaavnOriginalsAdapter extends RecyclerView.Adapter<JioSaavnOriginalsViewHolder> {
    private  List<JioSaavnOriginalsModelClass> jioSaavnOriginalsModelClassList;
    public JioSaavnOriginalsAdapter(List<JioSaavnOriginalsModelClass> jioSaavnOriginalsModelClassList) {
        this.jioSaavnOriginalsModelClassList = jioSaavnOriginalsModelClassList;
    }
    @NonNull
    @Override
    public JioSaavnOriginalsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jiosaavnoriginals_item_layout,parent,false);
        return new JioSaavnOriginalsViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull JioSaavnOriginalsViewHolder holder, int position) {
        JioSaavnOriginalsModelClass jioSaavnOriginalsModelClass = jioSaavnOriginalsModelClassList.get(position);
        holder.setJioSaavnOriginalsData(jioSaavnOriginalsModelClass);
    }
    @Override
    public int getItemCount() {
        return jioSaavnOriginalsModelClassList.size();
    }
}
