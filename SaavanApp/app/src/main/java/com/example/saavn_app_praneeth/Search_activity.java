package com.example.saavn_app_praneeth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.saavn_app_praneeth.Adapters.NewReleasesAdapter;
import com.example.saavn_app_praneeth.Adapters.SearchActivityAdapter;
import com.example.saavn_app_praneeth.Response.ResponseModel;
import com.example.saavn_app_praneeth.Response.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Search_activity extends AppCompatActivity {

    private  String data;
    private RecyclerView SearchRecyclerView;
    private List<ResultsItem> resultsItemList= new ArrayList<>();
    private SearchActivityAdapter searchActivityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activity);
        getData();
        initViews();


    }

    private void initViews() {
        SearchRecyclerView=findViewById(R.id.SearchActivityRecyclerView);
        callApi();
        setSearchAdapter();
    }

    private void setSearchAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        SearchRecyclerView.setLayoutManager(gridLayoutManager);
        searchActivityAdapter = new SearchActivityAdapter(resultsItemList);
        SearchRecyclerView.setAdapter(searchActivityAdapter);

    }

    private void callApi() {
        ApiService apiService=ApiNetwork.getRetrofitInstance().create(ApiService.class);
        apiService.getSongs(data).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body() != null) {
                    resultsItemList = response.body().getResults();
                    searchActivityAdapter.updateAdapter(resultsItemList);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }

    private void getData() {
        data=getIntent().getStringExtra("SearchKey");
    }
}