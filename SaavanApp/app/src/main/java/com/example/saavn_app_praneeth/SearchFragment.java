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

import com.example.saavn_app_praneeth.Adapters.SearchActivityAdapter;
import com.example.saavn_app_praneeth.Adapters.SearchFragmentAdapter;
import com.example.saavn_app_praneeth.Response.ResponseModel;
import com.example.saavn_app_praneeth.Response.ResultsItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    private List<ResultsItem> resultsItemList = new ArrayList<>();
    private RecyclerView SearchFragmentRecyclerView;
    private final String Trending="Trending Music";
    private SearchFragmentAdapter searchFragmentAdapter;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        CallApi();
        setSearchFragmentAdapter();
    }

    private void setSearchFragmentAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        SearchFragmentRecyclerView.setLayoutManager(gridLayoutManager);
        searchFragmentAdapter = new SearchFragmentAdapter(resultsItemList);
       SearchFragmentRecyclerView.setAdapter(searchFragmentAdapter);

    }

    private void CallApi() {
        ApiService apiService=ApiNetwork.getRetrofitInstance().create(ApiService.class);
        apiService.getSongs(Trending).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body() != null) {
                    resultsItemList = response.body().getResults();
                    searchFragmentAdapter.updateAdapter(resultsItemList);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }

    private void initViews(View view) {
        SearchFragmentRecyclerView = view.findViewById(R.id.SearchRecyclerView);

    }

}
