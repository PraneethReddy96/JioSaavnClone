package com.example.saavn_app_praneeth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.saavn_app_praneeth.Adapters.BrowseAdapter;
import com.example.saavn_app_praneeth.Adapters.SearchActivityAdapter;
import com.example.saavn_app_praneeth.Response.ResponseModel;
import com.example.saavn_app_praneeth.Response.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrowseFragment extends Fragment {

    private RecyclerView BrowseRecyclerView;
    private List<ResultsItem> resultsItemList = new ArrayList<>();
    private BrowseAdapter browseAdapter;
    private final String Browse= "Music";

    public BrowseFragment() {
        // Required empty public constructor
    }

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_browse, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        BrowseRecyclerView=view.findViewById(R.id.browseNewReleaseRecyclerView);
        callApi();
        setBrowseAdapter();
    }

    private void setBrowseAdapter() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        BrowseRecyclerView.setLayoutManager(gridLayoutManager);
        browseAdapter = new BrowseAdapter(resultsItemList);
        BrowseRecyclerView.setAdapter(browseAdapter);

    }

    private void callApi() {
        ApiService apiService=ApiNetwork.getRetrofitInstance().create(ApiService.class);
        apiService.getSongs(Browse).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body() != null) {
                    resultsItemList = response.body().getResults();
                    browseAdapter.updateAdapter(resultsItemList);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });


    }
}